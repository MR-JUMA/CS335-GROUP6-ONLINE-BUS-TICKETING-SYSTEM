package com.example.abc.services;

import com.example.abc.dao.ConnectionRepository;
import com.example.abc.dao.TicketRepository;
import com.example.abc.dao.UserRepository;
import com.example.abc.models.Connection;
import com.example.abc.models.PriceTable;
import com.exsmple.abc.models.Ticket;
import com.example.abc.models.User;
import com.example.abc.exceptions.BookedTooLateException;
import com.example.abc.exceptions.CancelBookTooLateException;
import com.example.abc.exceptions.NoTicketAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ConnectionRepository connectionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PriceTableService priceTableService;

    @Override
    public Ticket bookTicket(Long connectionId, String username) {
        Connection connection = connectionRepository.findOne(connectionId);
        if (connection == null) {
            throw new RuntimeException("Connection does not exist!");
        }
        User user = userRepository.findOneByEmail(username);
        if (user == null) {
            throw new RuntimeException("User does not exist!");
        }
        PriceTable priceTable = priceTableService.getPriceTable();

        long minutesToDeparture = getMinutesDiffBetweenDates(new Date(), connection.getDepartureDate());
        if (minutesToDeparture < 30) {
            throw new BookedTooLateException();
        }

        int ticketCount = connection.getTickets() != null ? connection.getTickets().size() : 0;
        if (ticketCount + 1 > connection.getPlaces()) {
            throw new NoTicketAvailableException();
        }

        Ticket ticket = new Ticket();
        ticket.setConnection(connection);
        ticket.setPrice(priceTable.getPricePerKilometer().multiply(new BigDecimal(connection.getDistance())));
        ticket.setUser(user);
        ticket.setReservationDate(new Date());
        ticket.setTicketNumber(UUID.randomUUID().toString());

        return ticketRepository.save(ticket);
    }

    @Override
    public void cancelBookTicket(Long ticketId, String username) {
        Ticket ticket = ticketRepository.findOne(ticketId);

        User user = userRepository.findOneByEmail(username);
        if (user == null) {
            throw new RuntimeException("User does not exist!");
        }

        if (!ticket.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Cannot delete ticket that you are not owner of!");
        }

        long minutesToDeparture = getMinutesDiffBetweenDates(new Date(), ticket.getConnection().getDepartureDate());
        if (minutesToDeparture < 30) {
            throw new CancelBookTooLateException();
        }

        ticketRepository.delete(ticket);
    }

    @Override
    public List<Ticket> getAllTicketsOfUser(String username) {
        User user = userRepository.findOneByEmail(username);
        if (user == null) {
            throw new RuntimeException("User does not exist!");
        }

        return ticketRepository.findByUserId(user.getId());
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.delete(id);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicket(Long id) {
        return ticketRepository.getOne(id);
    }

    private long getMinutesDiffBetweenDates(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();

        return TimeUnit.MILLISECONDS.toMinutes(diff);
    }
}

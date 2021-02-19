package com.example.abc.repositories;

import com.example.abc.models.BusSchedule;
import com.example.abc.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<BusSchedule,Long> {

    @Query("from BusSchedule")
    List<BusSchedule> displayTrips(String DepartureCity, String ArrivalCity);

    @Query("from BusSchedule")
    BusSchedule display();


}

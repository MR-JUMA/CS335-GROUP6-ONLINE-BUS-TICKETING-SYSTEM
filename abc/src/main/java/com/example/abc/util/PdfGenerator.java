package com.example.abc.util;

import com.example.abc.models.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;

@Component
public class PdfGenerator  {

    public void generateItinerary(Reservation reservation, String filePath){
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            document.add(generateTable(reservation));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public PdfPTable generateTable(Reservation reservation){
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell ;
        cell= new PdfPCell(new Phrase("Flight Itinerary"));
        cell.setColspan(2);
        table.addCell(cell);

        cell= new PdfPCell(new Phrase("Flight Details"));
        cell.setColspan(2);
        table.addCell(cell);

        //adding flight details


//
//        table.addCell("Departure city");
//        table.addCell(reservation.getFlight().getDepartureCity());
//
//
//        table.addCell("Arrival city");
//        table.addCell(reservation.getFlight().getArrivalCity());
//
//        table.addCell("Flight number ");
//        table.addCell(reservation.getFlight().getFlightNumber());
//
//        table.addCell("Departure Date");
//        table.addCell(String.valueOf(reservation.getFlight().getDateOfDeparture()));
//
//        table.addCell("Departure Time");
//        table.addCell(String.valueOf(reservation.getFlight().getEstimatedDepartureTime()));
//
//        table.addCell("Return Date");
//        table.addCell(String.valueOf(reservation.getFlight().getDateOfReturn()));
//
//
//        //adding passenger details
//        cell= new PdfPCell(new Phrase("Passenger Details"));
//        cell.setColspan(2);
//        table.addCell(cell);
//
//        table.addCell("First Name");
//        table.addCell(reservation.getPassenger().getFirstName());
//
//        table.addCell("Last Name");
//        table.addCell(reservation.getPassenger().getLastName());
//
//        table.addCell("Email");
//        table.addCell(reservation.getPassenger().getEmail());
//
//        table.addCell("Phone");
//        table.addCell(reservation.getPassenger().getPhone());
//
        return table;

    }

}

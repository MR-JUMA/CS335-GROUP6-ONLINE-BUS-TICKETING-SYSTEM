package com.example.abc.repositories;

import com.example.abc.models.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface BusRepository extends JpaRepository<BusSchedule,Long> {

    @Query(value = "from BusSchedule where DepartureCity=:departureCity and ArrivalCity=:arrivalCity and TravelDate=:departureDate")
    List<BusSchedule> findTrip(@Param("departureCity") String departureCity, @Param("arrivalCity") String arrivalCity, @Param("departureDate") Date departureDate);

}

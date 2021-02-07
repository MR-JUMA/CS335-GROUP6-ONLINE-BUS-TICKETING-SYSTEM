package com.example.abc.repositories;

import com.example.abc.models.Bus;
import com.example.abc.models.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Long> {


}

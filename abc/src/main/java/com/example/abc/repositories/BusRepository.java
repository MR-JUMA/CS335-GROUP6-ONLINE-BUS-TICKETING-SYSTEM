package com.example.abc.repositories;

import com.example.abc.models.Bus;
import com.example.abc.models.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;
@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {


}

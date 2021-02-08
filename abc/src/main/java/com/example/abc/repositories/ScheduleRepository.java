package com.example.abc.repositories;

import com.example.abc.models.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<BusSchedule,Long> {
}

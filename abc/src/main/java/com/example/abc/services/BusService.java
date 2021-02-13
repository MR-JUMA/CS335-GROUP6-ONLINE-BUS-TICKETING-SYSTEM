package com.example.abc.services;

import com.example.abc.models.Bus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BusService {
    Bus getBusById(int id);

}

package com.example.abc.services;

import com.example.abc.models.Bus;
import com.example.abc.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepository busRepository;

    @Override
    public Bus getBusById(int id) {
        return busRepository.findById((long) id).orElse(null);
    }
}

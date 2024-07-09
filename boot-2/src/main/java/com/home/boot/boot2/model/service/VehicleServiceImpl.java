package com.home.boot.boot2.model.service;

import com.home.boot.boot2.model.Vehicle;
import com.home.boot.boot2.model.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public DataTablesOutput<Vehicle> getVehicles(DataTablesInput input) {
        return vehicleRepository.findAll(input);
    }
}

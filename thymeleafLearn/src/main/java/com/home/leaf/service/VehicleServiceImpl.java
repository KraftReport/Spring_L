package com.home.leaf.service;

import com.home.leaf.model.Vehicle;
import com.home.leaf.repository.VehicleRepository;
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

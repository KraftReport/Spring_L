package com.home.boot.boot2.model.service;

import com.home.boot.boot2.model.Vehicle;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

public interface VehicleService {
    public DataTablesOutput<Vehicle> getVehicles(DataTablesInput input);
}

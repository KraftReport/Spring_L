package com.home.leaf.service;

import com.home.leaf.model.Vehicle;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

public interface VehicleService {
    public DataTablesOutput<Vehicle> getVehicles(DataTablesInput input);
}

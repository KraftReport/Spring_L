package com.home.leaf.controller;

import com.home.leaf.model.Vehicle;
import com.home.leaf.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/dataTables")
    public DataTablesOutput<Vehicle> vehicleDataTablesOutput(@RequestBody DataTablesInput input)
    {
        return  vehicleService.getVehicles(input);
    }
}

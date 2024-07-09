package com.home.boot.boot2.model.repository;

import com.home.boot.boot2.model.Vehicle;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends DataTablesRepository<Vehicle, Long> {
}

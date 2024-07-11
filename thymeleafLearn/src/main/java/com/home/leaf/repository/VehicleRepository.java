package com.home.leaf.repository;

import com.home.leaf.model.Vehicle;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends DataTablesRepository<Vehicle, Long>, JpaSpecificationExecutor<Vehicle> {
    DataTablesOutput<Vehicle> findAll(DataTablesInput input, Specification<Vehicle> specification);
}

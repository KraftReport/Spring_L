package com.home.leaf.service;

import com.home.leaf.model.Employee;
import com.home.leaf.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findById(Long id) {
        List<Employee> emp  = employeeRepository.findAllById(Collections.singleton(id));
        return  emp;
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}

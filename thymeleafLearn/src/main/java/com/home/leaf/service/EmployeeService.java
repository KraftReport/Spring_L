package com.home.leaf.service;

import com.home.leaf.model.Employee;
import org.springframework.beans.MutablePropertyValues;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public void saveEmployee(Employee employee);

    List<Employee> findById(Long id);

    void deleteById(Long id);
}

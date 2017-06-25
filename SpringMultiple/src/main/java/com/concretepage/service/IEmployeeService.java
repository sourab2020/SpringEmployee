package com.concretepage.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.concretepage.entity.Employee;


public interface IEmployeeService {
	
	List<Employee> getallEmployees();
    Employee getEmployeeById(int id);
    boolean addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);

}

package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Employee;

public interface IEmployeeDAO {
	
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    boolean employeeExists(String username);

}

package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concretepage.dao.IEmployeeDAO;
import com.concretepage.entity.Employee;

@Component
public class EmployeeService implements IEmployeeService {
   
	@Autowired
	private IEmployeeDAO employeeDAO;
	@Override
	public List<Employee> getallEmployees() {
		// TODO Auto-generated method stub
		 
		return employeeDAO.getAllEmployee();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee e= employeeDAO.getEmployeeById(id);
		
		return e;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(employeeDAO.employeeExists(employee.getUsername()))
		return false;
		
		else{
			employeeDAO.addEmployee(employee);
 	   return true;
	}
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 employeeDAO.updateEmployee(employee);

	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(id);

	}

}

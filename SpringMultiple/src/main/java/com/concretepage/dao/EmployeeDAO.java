package com.concretepage.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.concretepage.entity.Employee;

@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		String hql = "FROM Employee as p ORDER BY p.id";
		List<Employee> employee = (List<Employee>) hibernateTemplate.find(hql);
		return employee;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(Employee.class, id);
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 hibernateTemplate.save(employee);

	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee e = getEmployeeById(employee.getId());
		e.setFirstName(employee.getFirstName());
		e.setLastName(employee.getLastName());
		e.setAge(employee.getAge());
		e.setGender(employee.getGender());
		hibernateTemplate.update(e);

	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(getEmployeeById(id));

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean employeeExists(String username) {
		// TODO Auto-generated method stub
		String hql = "FROM Employee as p WHERE p.username = ?";
		List<Employee> employee = (List<Employee>) hibernateTemplate.find(hql, username);
		return employee.size() > 0 ? true : false;
		
	}

}

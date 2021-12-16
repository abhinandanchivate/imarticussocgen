package com.socgen.emplmngt.repository.impl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.socgen.emplmngt.dto.Employee;
import com.socgen.emplmngt.repository.EmployeeRepository;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	private Set<Employee> employees = new TreeSet<>();
	// 16
	// new HashSet(Collection)
	// new HashSet(size, load factor)
	//                   maps

	// singleton DP
	private static EmployeeRepository employeeRepository;

	private EmployeeRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	public static EmployeeRepository getInstance() {

		if (employeeRepository == null) {
			employeeRepository = new EmployeeRepositoryImpl();

		}
		return employeeRepository;
	}

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub

		boolean result = employees.add(employee);

		if (result)
			return "successs";
		else
			return "fail";
	}

	@Override
	public String updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(String id) {
		Employee employee = this.getEmployeeById(id);

		if (employee != null) {
			
			employees.remove(employee);
			return "success";

		} else

			return "not found";
	}

	@Override
	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub

		// to find the specific id ===> we need to retrieve the employee object ===>
		// available in employees
		// do we need to traverse the employees? ==> yes

		for (Employee employee : employees) {

			if (id.equals(employee.getEmpId())) {
				return employee;
			}

		}

		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return new ArrayList<>(employees);
		// set to list
	}

}

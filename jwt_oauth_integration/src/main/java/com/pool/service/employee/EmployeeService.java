package com.pool.service.employee;

import java.util.List;

import com.pool.forms.RegistrationForm;
import com.pool.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> employees();
	public RegistrationForm findByEmail(String userName);

}

package com.security.service.employee;

import java.util.List;

import com.security.forms.RegistrationForm;
import com.security.model.Employee;
import com.security.model.Registration;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> employees();
	public RegistrationForm findByEmail(String userName);

}

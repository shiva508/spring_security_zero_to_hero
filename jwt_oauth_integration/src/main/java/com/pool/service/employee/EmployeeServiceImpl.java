package com.security.service.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.forms.RegistrationForm;
import com.security.forms.RoleForm;
import com.security.model.Employee;
import com.security.model.Registration;
import com.security.model.Role;
import com.security.repository.employee.EmployeeRepository;
import com.security.repository.registration.RegistrationJpa;

import ma.glasnost.orika.MapperFacade;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RegistrationJpa registrationJpa;
	@Autowired
	@Qualifier("formDomineMapperfaced")
	private MapperFacade formDomineMapperfaced;
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> employees() {
		return employeeRepository.findAll();
	}

	@Override
	public RegistrationForm findByEmail(String userName) {
		Registration registration=registrationJpa.getUserByEmail(userName);
		RegistrationForm registrationForm=formDomineMapperfaced.map(registration, RegistrationForm.class);
		processRoles(registrationForm,registration);
		return  registrationForm;
	}

	private void processRoles(RegistrationForm registrationForm, Registration registration) {
		List<Role>list=registration.getRoles();
		for (Role role : list) {
			RoleForm roleForm=formDomineMapperfaced.map(role, RoleForm.class);
			registrationForm.getRoles().add(roleForm);
			
		}
	}

}

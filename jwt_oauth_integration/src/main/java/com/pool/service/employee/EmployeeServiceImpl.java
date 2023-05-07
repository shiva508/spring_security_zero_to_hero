package com.pool.service.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.forms.RegistrationForm;
import com.pool.forms.RoleForm;
import com.pool.model.Employee;
import com.pool.model.Registration;
import com.pool.model.Role;
import com.pool.repository.employee.EmployeeRepository;
import com.pool.repository.registration.RegistrationJpa;

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

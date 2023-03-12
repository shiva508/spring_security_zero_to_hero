package com.security.api.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.forms.RegistrationForm;
import com.security.model.Employee;import com.security.model.Registration;
import com.security.repository.registration.RegistrationJpa;
import com.security.service.employee.EmployeeService;
import com.security.service.registration.CustomUserDetailsService;
import com.security.service.registration.RegistrationService;
import com.security.service.reports.EmployeeJasperReport;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeJasperReport employeeJasperReport;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>>  employees(){
		return new ResponseEntity<List<Employee>>(employeeService.employees(), HttpStatus.OK);
	}
	@GetMapping("/report/{reportType}")
	public ResponseEntity<Object> generateReport(@ PathVariable("reportType") String reportType ){
		return new ResponseEntity<Object>(employeeJasperReport.generateEmployeeReport(reportType),HttpStatus.OK);
	}
	@GetMapping("/useraa/{userName}")
	public ResponseEntity<Object> findByEmail(@PathVariable("userName")String userName){
		return new ResponseEntity<>(customUserDetailsService.loadUserByUsername(userName),HttpStatus.OK );
	}
	
}

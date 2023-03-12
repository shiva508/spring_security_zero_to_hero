package com.security.service.reports;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.Employee;
import com.security.repository.employee.EmployeeRepository;
import com.security.uitil.JasperReportUtil;
import com.security.uitil.SecurityAppUtil;

@Service
@Transactional
public class EmployeeJasperReportImpl implements EmployeeJasperReport {
	@Autowired
	private EmployeeRepository EmployeeRepository;
	@Autowired
	private SecurityAppUtil securityAppUtil;
	@Autowired
	private JasperReportUtil jasperReportUtil;
	@Override
	public String generateEmployeeReport(String reportType) {
		List<Employee> employees = EmployeeRepository.findAll();
		File file = securityAppUtil.getFile("Employee.jrxml");
		if (file.getAbsoluteFile() != null) {
			jasperReportUtil.processJasperReport(reportType, employees, file);
		}
		return "Done";
	}

}

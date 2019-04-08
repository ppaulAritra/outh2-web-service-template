/**
 * 
 */
package com.cexpress.adminpanel.service;

import java.util.List;

import com.cexpress.adminpanel.domain.dto.EmployeeDTO;

/**
 * @author Aritra
 *
 */
public interface IEmployeeService {
	
	public EmployeeDTO createEmployee(EmployeeDTO employee);
	public EmployeeDTO updateEmployee(EmployeeDTO employee);
	public List<EmployeeDTO> getAllEmployee();
	public EmployeeDTO getEmployeeById(Long id);
	

}

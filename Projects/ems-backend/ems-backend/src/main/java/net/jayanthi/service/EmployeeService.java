package net.jayanthi.service;

import net.jayanthi.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto createEmployee(EmployeeDto employeedto);
    public EmployeeDto getEmployeeByID(Long id);
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto updateEmployee(Long id,EmployeeDto employee);
    public void deleteEmployee(Long id);
}

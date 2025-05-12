package net.jayanthi.Mapper;

import net.jayanthi.dto.EmployeeDto;
import net.jayanthi.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto maptoEmployeeDto(Employee employee){
        EmployeeDto employeedto = new EmployeeDto(
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail()
        );
                return employeedto;
    }
    public static Employee maptoEmployee(EmployeeDto employeedto){
        Employee employee = new Employee(
                employeedto.getId(), employeedto.getFirstName(), employeedto.getLastName(), employeedto.getEmail()
        );
        return employee;
    }
}

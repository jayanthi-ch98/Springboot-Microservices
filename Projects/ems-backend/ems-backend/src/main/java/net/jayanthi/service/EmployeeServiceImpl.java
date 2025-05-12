package net.jayanthi.service;

import net.jayanthi.Mapper.EmployeeMapper;
import net.jayanthi.dto.EmployeeDto;
import net.jayanthi.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.jayanthi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.jayanthi.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeedto) {
        Employee employee = EmployeeMapper.maptoEmployee(employeedto);
       Employee savedEmployee= employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeByID(Long id) {
        Employee employee= employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with the given Id doesn't exixts"));
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList= employeeList.stream().map(employee->EmployeeMapper.maptoEmployeeDto(employee))
                .collect(Collectors.toList());

        return employeeDtoList;

    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employeeById = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee doesn't exists for the given Employee Id"));
        employeeById.setFirstName((employeeDto.getFirstName() != null) ? employeeDto.getFirstName():employeeById.getFirstName());
        employeeById.setLastName((employeeDto.getLastName() != null) ? employeeDto.getLastName():employeeById.getLastName());
        employeeById.setEmail((employeeDto.getEmail() != null) ? employeeDto.getEmail():employeeById.getEmail());
        Employee savedEmployee = employeeRepository.save(employeeById);
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee with id Deosn't exist"));
        employeeRepository.deleteById(id);
    }
}

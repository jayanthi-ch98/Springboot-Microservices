package net.jayanthi.controller;

import net.jayanthi.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.jayanthi.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Rest API to create an employee in id
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto createdEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployee,HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value="id") Long employeeId){
        EmployeeDto employee=employeeService.getEmployeeByID(employeeId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        List<EmployeeDto> employeeList=employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeList);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody EmployeeDto employeeDto,@PathVariable Long id){
        EmployeeDto updatedEmployee=employeeService.updateEmployee(id,employeeDto);
        return  ResponseEntity.ok(updatedEmployee);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
      employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted suceesfully",HttpStatus.OK);
    }
}

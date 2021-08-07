package com.granickiy.spring.springboot.spring_data_jpa.controller;



import com.granickiy.spring.springboot.spring_data_jpa.entity.Employee;
import com.granickiy.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> showEmployeeDepartment(@PathVariable String department){
        List<Employee> employees = employeeService.getEmployeesByDepartmentName(department);
        return employees;
    }


    @GetMapping("/employees/name/{name}")
    public List<Employee> showEmployeeByName(@PathVariable String name){
        List<Employee> employees = employeeService.getEmployeesByName(name);
        return employees;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }


}

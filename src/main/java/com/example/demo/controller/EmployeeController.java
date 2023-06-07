
package com.example.demo.controller;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;

    @PostMapping
    public String addEmployee(@RequestBody EmployeeModel employeeModel){
        empService.insert(employeeModel);
        return "Employee added";
    }

    @GetMapping
    public List<EmployeeModel> getEmployeeDetails(){
        return empService.fetchAllDetails();
    }

    @PutMapping("{empid}")
    public String updateEmployeeDetails(@PathVariable String empid, @RequestBody EmployeeModel employeeModel){
        empService.updateDetails(empid, employeeModel);
        return "Employee updated";
    }   

    @DeleteMapping("{empid}")
    public String deleteEmployee(@PathVariable String empid){
        empService.deleteDetails(empid);
        return "Employee deleted";
    }
}
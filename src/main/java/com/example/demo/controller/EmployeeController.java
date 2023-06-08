
package com.example.demo.controller;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeModel employeeModel){
        empService.insert(employeeModel);
        return new ResponseEntity<String>("Employee added",HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<EmployeeModel> getEmployeeDetails(){
            return empService.fetchAllDetails();

    }

    @PutMapping("{empid}")
    public ResponseEntity<String> updateEmployeeDetails(@PathVariable String empid, @RequestBody EmployeeModel employeeModel){
            empService.updateDetails(empid, employeeModel);
            return new ResponseEntity<String>("Employee Updated",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{empid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String empid){
            empService.deleteDetails(empid);
            return new ResponseEntity<String>("Employee Deleted",HttpStatus.ACCEPTED);
    }
}
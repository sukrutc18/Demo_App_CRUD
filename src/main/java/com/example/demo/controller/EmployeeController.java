//package com.example.demo.controller;
//
//import com.example.demo.model.EmployeeModel;
//import com.example.demo.service.EmployeeService;
//import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Details;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController {
//    @Autowired
//    private EmployeeService empService;
//
//    @PostMapping
//    public String addEmployee(@RequestBody Details empDetails){
//        empService.insert(empDetails);
//        return "Employee added";
//    }
//
//    @GetMapping
//    public List<EmployeeModel> getEmployeeDetails(){
//        return empService.fetchAllDetails();
//    }
//
//    @PutMapping
//    public String updateEmployeeDetails(@RequestBody Details empDetails){
//        empService.updateDetails(empDetails);
//        return "Employee updated";
//    }
//
//    @DeleteMapping
//    public String deleteEmployee(@RequestParam int empid){
//        empService.deleteDetails(empid);
//        return "Employee deleted";
//    }
//}
//

package com.example.demo.controller;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Details;
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
    public String updateEmployeeDetails(@PathVariable int empid, @RequestBody EmployeeModel employeeModel){
        empService.updateDetails(empid, employeeModel);
        return "Employee updated";
    }

    @DeleteMapping
    public String deleteEmployee(@RequestParam int empid){
        empService.deleteDetails(empid);
        return "Employee deleted";
    }
}
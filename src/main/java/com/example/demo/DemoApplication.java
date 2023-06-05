package com.example.demo;

import 	com.example.demo.records.EmployeeDetails;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/employees")
public class DemoApplication {

	@Autowired
	private EmployeeDetails details;

	@PostMapping
	public String addEmployee(@RequestBody Details empDetails){
		details.addEmployee(empDetails);
		return "Employee added";
	}

	@GetMapping
	public List<Details> getEmployeeDetails(){
		return details.getEmployeeDetails();
	}


	@PutMapping
	public String updateEmployeeDetails(@RequestBody Details empDetails){
		details.updateEmployeeDetails(empDetails);
		return "Employee updated";
	}

	@DeleteMapping
	public String deleteEmployee(@RequestBody Details empDetails){
		details.deleteEmployee(empDetails);
		return "Employee deleted";
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

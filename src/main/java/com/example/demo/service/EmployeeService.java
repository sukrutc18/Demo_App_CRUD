package com.example.demo.service;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.EmployeeRepository;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Address;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Details;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;
    @Autowired
    private AddressService addressService;

    public void insert(EmployeeModel employeeModel) {
        Details empDetails = new Details();
        BeanUtils.copyProperties(employeeModel,empDetails);
        int newEmpId = empRepository.addEmployee(empDetails);

        Address empaddress=new Address();
        BeanUtils.copyProperties(employeeModel.getAddressModel(),empaddress);
        empaddress.setEmpid(newEmpId);
        addressService.insert(empaddress);
    }

    public List<EmployeeModel> fetchAllDetails(){
        List<Details> employees = empRepository.getEmployeeDetails();
        List<EmployeeModel> models = new ArrayList<>();
        for (Details employee: employees) {
            EmployeeModel model=new EmployeeModel();
            BeanUtils.copyProperties(employee, model);
            addressService.fetchAddress(employee.getEmpid(), model);

            models.add(model);
        }
        return models;
    }



    public void updateDetails(int empid, EmployeeModel employeeModel){
        Details empDetails=new Details();
        BeanUtils.copyProperties(employeeModel,empDetails);
        empRepository.updateEmployeeDetails(empid, empDetails);
    }

    public void deleteDetails(int empid){
        empRepository.deleteEmployee(empid);
    }
}

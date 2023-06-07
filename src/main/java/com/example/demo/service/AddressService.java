package com.example.demo.service;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.AddressRepository;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Address;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Details;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public void insert(Address address) {
       addressRepository.addAddress(address);
    }

    public EmployeeModel fetchAddress(int empid, EmployeeModel employeeModel){
        BeanUtils.copyProperties(addressRepository.getAddressById(empid),
                employeeModel);
        return employeeModel;
    }



    public void updateDetails(int empid, EmployeeModel employeeModel){

    }

    public void deleteDetails(int empid){

    }
}

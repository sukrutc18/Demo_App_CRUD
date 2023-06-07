package com.example.demo.service;

import com.example.demo.model.AddressModel;
import com.example.demo.repository.AddressRepository;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public void insert(Address address) {
       addressRepository.addAddress(address);
    }

    public AddressModel fetchAddress(String empid){
        AddressModel addressModel=new AddressModel();
        BeanUtils.copyProperties(addressRepository.getAddressById(empid),
                addressModel);
        return addressModel;
    }



    public void updateAddress(String empid, AddressModel addressModel){
        Address address= new Address();
        BeanUtils.copyProperties(addressModel,address);
        addressRepository.updateAddress(empid, address);
    }

    public void deleteDetails(String empid){
        addressRepository.deleteAddress(empid);
    }
}

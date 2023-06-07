package com.example.demo.model;

import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Address;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
    private String name;
    private int age;
    private Double salary;
    private AddressModel addressModel;
}
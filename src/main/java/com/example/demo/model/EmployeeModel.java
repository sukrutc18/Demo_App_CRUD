package com.example.demo.model;

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
    private AddressModel address;
}
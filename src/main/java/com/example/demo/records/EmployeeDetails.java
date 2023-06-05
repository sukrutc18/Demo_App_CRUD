package com.example.demo.records;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Details;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDetails {
    @Autowired
    private DSLContext dslContext;

    public void addEmployee(Details empDetails){
        dslContext.insertInto(Tables.DETAILS,
                        Tables.DETAILS.EMPID,
                        Tables.DETAILS.NAME,
                        Tables.DETAILS.AGE,
                        Tables.DETAILS.SALARY)
                .values(empDetails.getEmpid(),
                        empDetails.getName(),
                        empDetails.getAge(),
                        empDetails.getSalary())
                .execute();
    }

    public List<Details> getEmployeeDetails(){
        return dslContext.selectFrom(Tables.DETAILS)
                .fetchInto(Details.class);
    }

    public void updateEmployeeDetails(Details empDetails){
        dslContext.update(Tables.DETAILS)
                .set(Tables.DETAILS.EMPID, empDetails.getEmpid())
                .set(Tables.DETAILS.NAME, empDetails.getName())
                .set(Tables.DETAILS.AGE, empDetails.getAge())
                .set(Tables.DETAILS.SALARY, empDetails.getSalary())
                .where(Tables.DETAILS.EMPID.eq(empDetails.getEmpid()))
                .execute();
    }

    public void deleteEmployee(Details empDetails){
        dslContext.deleteFrom(Tables.DETAILS)
                .where(Tables.DETAILS.EMPID.eq(empDetails.getEmpid()))
                .execute();
    }


}

package com.example.demo.repository;

import java.util.UUID;

import com.example.demo.exception.RecordNotFoundException;
import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Details;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private DSLContext dslContext;

    public String addEmployee(Details empDetails){
        String empid = UUID.randomUUID().toString();

        dslContext.insertInto(Tables.DETAILS,
                        Tables.DETAILS.EMPID,
                        Tables.DETAILS.NAME,
                        Tables.DETAILS.AGE,
                        Tables.DETAILS.SALARY)
                .values(empid,
                        empDetails.getName(),
                        empDetails.getAge(),
                        empDetails.getSalary())
                .execute();

        return empid;
    }

    public List<Details> getEmployeeDetails() {
        return dslContext.selectFrom(Tables.DETAILS)
                .fetchInto(Details.class);
    }


    public void updateEmployeeDetails(String empid, Details empDetails) {
        if (dslContext.selectCount()
                .from(Tables.DETAILS)
                .where(Tables.DETAILS.EMPID.eq(empid))
                .fetchInto(int.class).get(0)==0)
        {
            throw new RecordNotFoundException();
        }

        dslContext.update(Tables.DETAILS)
                .set(Tables.DETAILS.NAME, empDetails.getName())
                .set(Tables.DETAILS.AGE, empDetails.getAge())
                .set(Tables.DETAILS.SALARY, empDetails.getSalary())
                .where(Tables.DETAILS.EMPID.eq(empid))
                .execute();
    }

    public void deleteEmployee(String empid) {
        if (dslContext.selectCount()
                .from(Tables.DETAILS)
                .where(Tables.DETAILS.EMPID.eq(empid))
                .fetchInto(int.class).get(0)==0)
        {
            throw new RecordNotFoundException();
        }

        dslContext.deleteFrom(Tables.DETAILS)
                .where(Tables.DETAILS.EMPID.eq(empid))
                .execute();
    }

}

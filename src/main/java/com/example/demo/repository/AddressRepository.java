package com.example.demo.repository;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Address;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepository {
    @Autowired
    private DSLContext dslContext;

    public void addAddress(Address address){
        dslContext.insertInto(Tables.ADDRESS,
                        Tables.ADDRESS.EMPID,
                        Tables.ADDRESS.ADDRESS1)
                .values(address.getEmpid(),
                        address.getAddress1())
                .execute();
    }

    public Address getAddressById(int id){
        return dslContext.selectFrom(Tables.ADDRESS)
                .where(Tables.ADDRESS.EMPID.eq(id))
                .fetchInto(Address.class).get(0);
    }




    public void updateAddress(int empid, Address address){
        dslContext.update(Tables.ADDRESS)
                .set(Tables.ADDRESS.ADDRESS1, address.getAddress1())
                .where(Tables.ADDRESS.EMPID.eq(empid))
                .execute();
    }

    public void deleteAddress(int empid){
        dslContext.deleteFrom(Tables.ADDRESS)
                .where(Tables.ADDRESS.EMPID.eq(empid))
                .execute();
    }
}

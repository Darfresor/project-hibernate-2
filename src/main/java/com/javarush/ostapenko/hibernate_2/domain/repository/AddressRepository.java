package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Address;
import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AddressRepository extends GenericRepository<Address> {

    public AddressRepository(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}

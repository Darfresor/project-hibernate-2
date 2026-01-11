package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Customer;
import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerRepository extends GenericRepository<Customer>{
    public CustomerRepository(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}

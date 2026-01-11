package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Country;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CountryRepository extends GenericRepository<Country>{
    public CountryRepository(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}

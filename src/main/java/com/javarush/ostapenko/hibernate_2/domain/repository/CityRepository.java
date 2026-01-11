package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.City;
import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CityRepository extends GenericRepository<City>{
    public CityRepository(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }
}

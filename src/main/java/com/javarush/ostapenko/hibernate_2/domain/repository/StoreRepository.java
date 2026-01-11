package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Store;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StoreRepository extends GenericRepository<Store>{
    public StoreRepository(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}

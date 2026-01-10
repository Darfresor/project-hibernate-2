package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Store;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StoreRepository {
    private final SessionFactory sessionFactory;

    public StoreRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Store> getAll() {
        Query<Store> query = sessionFactory.getCurrentSession().createQuery("select c from Store c", Store.class);
        return query.list();
    }
}

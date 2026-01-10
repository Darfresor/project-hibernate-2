package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class RentalRepository {
    private final SessionFactory sessionFactory;

    public RentalRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Rental> getAll() {
        Query<Rental> query = sessionFactory.getCurrentSession().createQuery("select c from Rental c", Rental.class);
        return query.list();
    }
}

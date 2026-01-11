package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Payment;
import com.javarush.ostapenko.hibernate_2.domain.entity.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class RentalRepository extends GenericRepository<Rental>{
    public RentalRepository(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }
}

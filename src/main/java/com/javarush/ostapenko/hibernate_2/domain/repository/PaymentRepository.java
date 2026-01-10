package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Payment;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PaymentRepository {
    private final SessionFactory sessionFactory;

    public PaymentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Payment> getAll() {
        Query<Payment> query = sessionFactory.getCurrentSession().createQuery("select c from Payment c", Payment.class);
        return query.list();
    }
}

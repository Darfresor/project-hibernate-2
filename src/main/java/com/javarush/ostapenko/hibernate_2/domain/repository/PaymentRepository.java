package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Payment;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PaymentRepository extends GenericRepository<Payment> {
    public PaymentRepository(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}

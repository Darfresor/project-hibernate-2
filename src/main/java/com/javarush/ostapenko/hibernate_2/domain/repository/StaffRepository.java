package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Staff;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StaffRepository {
    private final SessionFactory sessionFactory;

    public StaffRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Staff> getAll() {
        Query<Staff> query = sessionFactory.getCurrentSession().createQuery("select c from Staff c", Staff.class);
        return query.list();
    }
}

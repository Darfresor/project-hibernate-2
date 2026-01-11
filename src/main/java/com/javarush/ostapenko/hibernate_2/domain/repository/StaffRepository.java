package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Staff;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StaffRepository extends GenericRepository<Staff>{
    public StaffRepository(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}

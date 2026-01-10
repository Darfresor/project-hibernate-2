package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Inventory;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class InventoryRepository {
    private final SessionFactory sessionFactory;

    public InventoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Inventory> getAll() {
        Query<Inventory> query = sessionFactory.getCurrentSession().createQuery("select c from Inventory c", Inventory.class);
        return query.list();
    }
}

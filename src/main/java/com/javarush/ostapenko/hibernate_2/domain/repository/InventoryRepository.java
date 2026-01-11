package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Inventory;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class InventoryRepository extends GenericRepository<Inventory>{

    public InventoryRepository(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}

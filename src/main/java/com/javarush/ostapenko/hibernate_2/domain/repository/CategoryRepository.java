package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Category;
import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryRepository {
    private final SessionFactory sessionFactory;

    public CategoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Category> getAll() {
        Query<Category> query = sessionFactory.getCurrentSession().createQuery("select c from Category c", Category.class);
        return query.list();
    }
}

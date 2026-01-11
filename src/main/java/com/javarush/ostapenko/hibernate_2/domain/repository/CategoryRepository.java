package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Category;
import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryRepository extends GenericRepository<Category>{

    public CategoryRepository(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}

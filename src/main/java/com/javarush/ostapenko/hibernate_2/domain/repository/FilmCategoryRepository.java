package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Customer;
import com.javarush.ostapenko.hibernate_2.domain.entity.FilmCategory;
import org.hibernate.SessionFactory;

public class FilmCategoryRepository  extends GenericRepository<FilmCategory>{
    public FilmCategoryRepository(SessionFactory sessionFactory) {
        super(FilmCategory.class, sessionFactory);
    }
}

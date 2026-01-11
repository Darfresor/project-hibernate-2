package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FilmRepository extends GenericRepository<Film>{


    public FilmRepository(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }
}

package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FilmRepository {
    private final SessionFactory sessionFactory;

    public FilmRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Film> getAll() {
        Query<Film> query = sessionFactory.getCurrentSession().createQuery("select c from Film c", Film.class);
        return query.list();
    }


}

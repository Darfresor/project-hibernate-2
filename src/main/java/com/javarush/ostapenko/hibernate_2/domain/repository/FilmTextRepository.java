package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.FilmText;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FilmTextRepository {
    private final SessionFactory sessionFactory;

    public FilmTextRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<FilmText> getAll() {
        Query<FilmText> query = sessionFactory.getCurrentSession().createQuery("select c from FilmText c", FilmText.class);
        return query.list();
    }
}

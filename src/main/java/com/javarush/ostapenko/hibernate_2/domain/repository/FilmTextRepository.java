package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.FilmText;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FilmTextRepository extends GenericRepository<FilmText>{

    public FilmTextRepository(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}

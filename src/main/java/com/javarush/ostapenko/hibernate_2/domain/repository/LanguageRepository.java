package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Language;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class LanguageRepository {
    private final SessionFactory sessionFactory;

    public LanguageRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Language> getAll() {
        Query<Language> query = sessionFactory.getCurrentSession().createQuery("select c from Language c", Language.class);
        return query.list();
    }
}

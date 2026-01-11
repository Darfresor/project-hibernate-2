package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Language;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class LanguageRepository extends GenericRepository<Language>{

    public LanguageRepository(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}

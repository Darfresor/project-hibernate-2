package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Actor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ActorRepository {
    private final SessionFactory sessionFactory;

    public ActorRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Actor> getAll() {
        Query<Actor> query = sessionFactory.getCurrentSession().createQuery("select c from Actor c", Actor.class);
        return query.list();
    }
}

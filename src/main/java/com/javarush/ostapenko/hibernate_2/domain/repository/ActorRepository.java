package com.javarush.ostapenko.hibernate_2.domain.repository;

import com.javarush.ostapenko.hibernate_2.domain.entity.Actor;
import org.hibernate.SessionFactory;


public class ActorRepository extends GenericRepository<Actor>{
    public ActorRepository(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }
}

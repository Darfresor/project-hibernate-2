package com.javarush.ostapenko.hibernate_2;

import com.javarush.ostapenko.hibernate_2.domain.entity.Actor;
import com.javarush.ostapenko.hibernate_2.domain.entity.Film;
import com.javarush.ostapenko.hibernate_2.domain.entity.Language;
import com.javarush.ostapenko.hibernate_2.domain.repository.ActorRepository;
import com.javarush.ostapenko.hibernate_2.domain.repository.FilmRepository;
import com.javarush.ostapenko.hibernate_2.domain.repository.LanguageRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.*;

import static java.util.Objects.nonNull;

public class Main {
    private final SessionFactory sessionFactory;

    private final FilmRepository filmRepository;
    private final ActorRepository actorRepository;
    private final LanguageRepository languageRepository;


    public Main() {
        this.sessionFactory = prepareRelationalDb();
        this.filmRepository = new FilmRepository(sessionFactory);
        this.actorRepository = new ActorRepository(sessionFactory);
        this.languageRepository = new LanguageRepository(sessionFactory);
    }



    private void shutdown() {
        if (nonNull(sessionFactory)) {
            sessionFactory.close();
        }
    }
    private SessionFactory prepareRelationalDb() {
        final SessionFactory sessionFactory;
        Properties properties = new Properties();

        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
        properties.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/movie");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "validate");
        properties.put(Environment.STATEMENT_BATCH_SIZE, "100");


        sessionFactory = new Configuration()
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Language.class)
                .addProperties(properties)
                .buildSessionFactory();
        return sessionFactory;
    }

    private void getEntity(Main main){
        try (Session session = main.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Film> filmList = filmRepository.getAll();
            System.out.println(filmList);

//            List<Actor> actorList = actorRepository.getAll();
//            System.out.println(actorList);


//            List<Language> languageList = languageRepository.getAll();
//            System.out.println(languageList);



            session.getTransaction().commit();
        }
    }




    public static void main(String[] args) {
        Main main = new Main();
        main.getEntity(main);



        main.shutdown();
    }




}

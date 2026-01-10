package com.javarush.ostapenko.hibernate_2;

import com.javarush.ostapenko.hibernate_2.domain.entity.*;
import com.javarush.ostapenko.hibernate_2.domain.repository.*;
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
    private final CategoryRepository categoryRepository;
    private final FilmTextRepository filmTextRepository;
    private final InventoryRepository inventoryRepository;
    private final StoreRepository storeRepository;
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;
    private final PaymentRepository paymentRepository;
    private final StaffRepository staffRepository;


    public Main() {
        this.sessionFactory = prepareRelationalDb();
        this.filmRepository = new FilmRepository(sessionFactory);
        this.actorRepository = new ActorRepository(sessionFactory);
        this.languageRepository = new LanguageRepository(sessionFactory);
        this.categoryRepository = new CategoryRepository(sessionFactory);
        this.filmTextRepository = new FilmTextRepository(sessionFactory);
        this.inventoryRepository = new InventoryRepository(sessionFactory);
        this.storeRepository = new StoreRepository(sessionFactory);
        this.addressRepository = new AddressRepository(sessionFactory);
        this.cityRepository = new CityRepository(sessionFactory);
        this.countryRepository = new CountryRepository(sessionFactory);
        this.customerRepository = new CustomerRepository(sessionFactory);
        this.rentalRepository = new RentalRepository(sessionFactory);
        this.paymentRepository = new PaymentRepository(sessionFactory);
        this.staffRepository = new StaffRepository(sessionFactory);
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
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Store.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Staff.class)
                .addProperties(properties)
                .buildSessionFactory();
        return sessionFactory;
    }

    private void getEntity(Main main){
        try (Session session = main.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
//            List<Film> filmList = filmRepository.getAll();
//            System.out.println(filmList.get(0).getFilmText());

//            List<Actor> actorList = actorRepository.getAll();
//            System.out.println(actorList);


//            List<Language> languageList = languageRepository.getAll();
//            System.out.println(languageList);

//            List<Category> categoryListList = categoryRepository.getAll();
//            System.out.println(categoryListList);

//            List<FilmText> filmTexts = filmTextRepository.getAll();
//            System.out.println(filmTexts);

//            List<Inventory> inventoryList = inventoryRepository.getAll();
//            System.out.println(inventoryList.get(0).getStore());

//            List<Store> storeList = storeRepository.getAll();
//            System.out.println(storeList.get(0).getStaff());

//            List<Address> addressList = addressRepository.getAll();
//            System.out.println(addressList.get(0).getCity());

//            List<City> cityList = cityRepository.getAll();
//            System.out.println(cityList.get(0).getCounty());

//            List<Country> countryList = countryRepository.getAll();
//            System.out.println(countryList);

//            List<Customer> customerList = customerRepository.getAll();
//            System.out.println(customerList.get(0).getStore());

//            List<Rental> rentalList = rentalRepository.getAll();
//            System.out.println(rentalList.get(0).getStaff());

            List<Payment> paymentList = paymentRepository.getAll();
            System.out.println(paymentList.get(0).getStaff());

//            List<Staff> staffList = staffRepository.getAll();
//            System.out.println(staffList.get(0).getAddress());

            session.getTransaction().commit();
        }
    }




    public static void main(String[] args) {
        Main main = new Main();
        main.getEntity(main);



        main.shutdown();
    }




}

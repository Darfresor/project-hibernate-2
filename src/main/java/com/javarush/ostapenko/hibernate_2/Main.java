package com.javarush.ostapenko.hibernate_2;

import com.javarush.ostapenko.hibernate_2.domain.entity.*;
import com.javarush.ostapenko.hibernate_2.domain.repository.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    private void getEntity(Main main) {
        try (Session session = main.sessionFactory.getCurrentSession()) {
            session.beginTransaction();

//            List<Film> filmList = filmRepository.findAll();
//            System.out.println(filmList.get(0).getRating());
//
//            List<Actor> actorList = actorRepository.findAll();
//            System.out.println(actorList);
//
//
//            List<Language> languageList = languageRepository.findAll();
//            System.out.println(languageList);
//
//            List<Category> categoryListList = categoryRepository.findAll();
//            System.out.println(categoryListList);
//
            List<FilmText> filmTexts = filmTextRepository.findAll();
            System.out.println(filmTexts.get(0).getFilm());
//
//            List<Inventory> inventoryList = inventoryRepository.findAll();
//            System.out.println(inventoryList.get(0).getStore());
//
//            List<Store> storeList = storeRepository.findAll();
//            System.out.println(storeList.get(0).getStaff());
//
//            List<Address> addressList = addressRepository.findAll();
//            System.out.println(addressList.get(0).getCity());
//
//            List<City> cityList = cityRepository.findAll();
//            System.out.println(cityList.get(0).getCounty());
//
//            List<Country> countryList = countryRepository.findAll();
//            System.out.println(countryList);
//
//            List<Customer> customerList = customerRepository.findAll();
//            System.out.println(customerList.get(0).getStore());
//
//            List<Rental> rentalList = rentalRepository.findAll();
//            System.out.println(rentalList.get(0).getStaff());
//
//            List<Payment> paymentList = paymentRepository.findAll();
//            System.out.println(paymentList.get(0).getStaff());

//            List<Staff> staffList = staffRepository.findAll();
//            System.out.println(staffList.get(0).getAddress());

            session.getTransaction().commit();
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.getEntity(main);
        main.createCustomer();
        main.returnRentedMovie();
        main.customerRentsFromStore();
        main.addNewFilmInCollection();

        main.shutdown();
    }

    private void addNewFilmInCollection() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Language language = languageRepository.getById(1);

            Category category = categoryRepository.getById(1);
            List<Category> categoryList = new ArrayList<>();
            categoryList.add(category);

            Actor actor1 = actorRepository.getById(1);
            Actor actor2 = actorRepository.getById(2);
            List<Actor> actorList = new ArrayList<>();
            actorList.add(actor1);
            actorList.add(actor2);


            Film film = new Film();
            film.setTitle("little pony2");
            film.setDescription("little little pony2");
            film.setReleaseYear(2026);
            film.setLanguage(language);
            film.setRentalDuration(20);
            film.setRentalRate(BigDecimal.valueOf(1.99));
            film.setLength((short) 13);
            film.setReplacementCost(BigDecimal.valueOf(13.33));
            film.setRating(Rating.valueOf("PG"));
            film.setSpecialFeatures("Deleted Scenes,Behind the Scenes");
            film.setCategoryList(categoryList);
            film.setActorList(actorList);
            filmRepository.save(film);

            FilmText filmText = new FilmText();
            filmText.setId(film.getId());
            filmText.setTitle("little pony2");
            filmText.setDescription("little little pony2");
            filmText.setFilm(film);
            filmTextRepository.save(filmText);

            session.getTransaction().commit();
        }
    }

    private void customerRentsFromStore() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Customer customer = customerRepository.getById(1);
            Store store = storeRepository.getById(1);
            Staff staff = store.getStaff();
            Inventory inventory = inventoryRepository.getById(2294);

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setCustomer(customer);
            rental.setStaff(staff);
            rentalRepository.save(rental);

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setStaff(staff);
            payment.setRental(rental);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setAmount(BigDecimal.valueOf(55.47));
            paymentRepository.save(payment);

            session.getTransaction().commit();
        }
    }

    private void returnRentedMovie() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Rental rental = rentalRepository.getById(11496);
            rental.setReturnDate(LocalDateTime.now());
            rentalRepository.save(rental);


            session.getTransaction().commit();
        }
    }

    private Customer createCustomer() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Store store = storeRepository.getItems(0, 1).get(0);

            City city = cityRepository.getById(1);

            Address address = new Address();
            address.setAddress("Аргентина");
            address.setDistrict("Третий дистрикт");
            address.setCity(city);
            address.setPostal_code("90349495");
            address.setPhone("2340240240");
            addressRepository.save(address);

            Customer customer = new Customer();
            customer.setStore(store);
            customer.setFirstName("first");
            customer.setLastName("last");
            customer.setEmail("email");
            customer.setAddress(address);
            customer.setActive(true);
            customerRepository.save(customer);

            session.getTransaction().commit();
            return customer;
        }
    }


}

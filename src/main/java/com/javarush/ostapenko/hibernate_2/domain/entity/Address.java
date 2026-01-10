package com.javarush.ostapenko.hibernate_2.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "address", schema = "movie")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Short id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="city_id")
    private City city;

    @Column(name="last_update")
    private Date lastUpdate;

    @Column(length = 50)
    private String address;

    @Column(length = 50)
    private String address2;

    @Column(length = 20)
    private String district;

    @Column(name="postal_code", length = 10)
    private String postal_code;

    @Column(length = 20)
    private String phone;

}

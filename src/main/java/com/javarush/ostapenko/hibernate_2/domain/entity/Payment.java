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

@Entity
@Table(name = "payment", schema = "movie")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Short id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="staff_id")
    @JdbcTypeCode(Types.TINYINT)
    private Short staffId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rental_id")
    private Rental rental;

    private BigDecimal amount;

    @Column(name="payment_date")
    private Date paymentDate;

    @Column(name="last_update")
    private Date lastUpdate;
}

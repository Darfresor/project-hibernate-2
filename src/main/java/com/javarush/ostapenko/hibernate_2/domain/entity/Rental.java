package com.javarush.ostapenko.hibernate_2.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.Date;

@Entity
@Table(name = "rental", schema = "movie")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer id;

    @Column(name="rental_date")
    private Date rentalDate;

    @Column(name="inventory_id")
    private Integer inventoryId;

    @Column(name="customer_id")
    private Short customerId;

    @Column(name="return_date")
    private Date returnDate;

    @Column(name="staff_id")
    @JdbcTypeCode(Types.TINYINT)
    private Short staffId;

    @Column(name="last_update")
    private Date lastUpdate;
}

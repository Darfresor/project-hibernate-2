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
@Table(name = "store", schema = "movie")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    @JdbcTypeCode(Types.TINYINT)
    private Short id;

    @Column(name = "manager_staff_id")
    @JdbcTypeCode(Types.TINYINT)
    private Short managerStaffId;

    @Column(name = "address_id")
    private Short addressId;

    @Column(name = "last_update")
    private Date lastUpdate;
}

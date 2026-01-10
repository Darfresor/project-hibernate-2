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
@Table(name = "staff", schema = "movie")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    @JdbcTypeCode(Types.TINYINT)
    private Short id;

    @Column(name="first_name", length = 45)
    private String firstName;

    @Column(name="last_name", length = 45)
    private String lastName;

    @Column(name="address_id")
    private Short addressId;


    private byte[] picture;

    @Column(name="email", length = 50)
    private String email;



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    @JdbcTypeCode(Types.BIT)
    private Boolean active;

    @Column(name="username", length = 16)
    private String username;

    @Column(name="password", length = 50)
    private String password;

    @Column(name = "last_update")
    private Date lastUpdate;
}

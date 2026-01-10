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
@Table(name = "category", schema = "movie")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(Types.TINYINT)
    @Column(name="category_id")
    private Short id;

    @Column(name="last_update")
    private Date lastUpdate;

    @Column(name="name", length = 25)
    private String name;
}

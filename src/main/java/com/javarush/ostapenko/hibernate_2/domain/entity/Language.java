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
@Table(name = "language", schema = "movie")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id")
    @JdbcTypeCode(Types.TINYINT)
    private Short id;
    @Column(name="last_update")
    private Date lastUpdate;
    @JdbcTypeCode(Types.CHAR)
    private String name;

}

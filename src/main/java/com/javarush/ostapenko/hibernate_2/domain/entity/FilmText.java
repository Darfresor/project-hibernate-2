package com.javarush.ostapenko.hibernate_2.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;

@Entity
@Table(name = "film_text", schema = "movie")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class FilmText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Short id;

    @Column(length = 255)
    private String title;

    @JdbcTypeCode(Types.LONGVARCHAR)
    private String description;
}

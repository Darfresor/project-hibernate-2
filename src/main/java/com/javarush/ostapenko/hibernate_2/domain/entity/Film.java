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
@Table(name = "film", schema = "movie")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Short id;
    @Column(length = 128)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "release_year", columnDefinition = "YEAR")
    private Integer releaseYear;
    @Column(name = "language_id")
    @JdbcTypeCode(Types.TINYINT)
    private Integer languageId;
    @Column(name = "original_language_id")
    @JdbcTypeCode(Types.TINYINT)
    private Integer originalLanguageId;
    @Column(name = "rental_duration")
    @JdbcTypeCode(Types.TINYINT)
    private Integer rentalDuration;
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;
    private Short length;
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;
    @JdbcTypeCode(Types.CHAR)
    private String rating;
    @Column(name = "special_features")
    @JdbcTypeCode(Types.CHAR)
    private String specialFeatures;
    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actorList;


}

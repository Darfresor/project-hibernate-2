package com.javarush.ostapenko.hibernate_2.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name="actor",schema = "movie")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="actor_id")
    private Short id;
    @Column(name="first_name", length = 45)
    private String firstName;
    @Column(name="last_name", length = 45)
    private String lastName;
    @Column(name="last_update")
    private Date lastUpdate;

}

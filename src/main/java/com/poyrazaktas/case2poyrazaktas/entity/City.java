package com.poyrazaktas.case2poyrazaktas.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CITY")
@Data
public class City {
    @Id
    @GeneratedValue(generator = "City")
    @SequenceGenerator(name="City",sequenceName = "CITY_SEQ")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int licensePlate;

}

package com.poyrazaktas.case2poyrazaktas.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="COUNTRY")
@Data
public class Country {
    @Id
    @GeneratedValue(generator = "Country")
    @SequenceGenerator(name="Country", sequenceName = "COUNTRY_SEQ")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int countryCode;
}

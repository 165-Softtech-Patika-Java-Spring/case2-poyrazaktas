package com.poyrazaktas.case2poyrazaktas.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "city")
    private List<District> districtList = new ArrayList<District>();

    @Column(name = "country_id", insertable = false, updatable = false)
    private int countyId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name="country_id",nullable = false)
    private Country country;

    @OneToOne(mappedBy = "city")
    private Address address;
}

package com.poyrazaktas.case2poyrazaktas.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data
public class Address {
    @Id
    @GeneratedValue(generator = "Address")
    @SequenceGenerator(name="Address", sequenceName = "ADDRESS_SEQ")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="country_id",referencedColumnName = "id")
    private Country country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="city_id",referencedColumnName = "id")
    private City city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="district_id",referencedColumnName = "id")
    private District district;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="neighborhood_id",referencedColumnName = "id")
    private Neighborhood neighborhood;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="street_id",referencedColumnName = "id")
    private Street street;

    private int gateNumber;
    private int apartmentNumber;
}

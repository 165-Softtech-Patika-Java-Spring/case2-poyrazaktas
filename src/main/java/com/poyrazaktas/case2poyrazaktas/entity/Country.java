package com.poyrazaktas.case2poyrazaktas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COUNTRY")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cityList"})
public class Country {
    @Id
    @GeneratedValue(generator = "Country")
    @SequenceGenerator(name = "Country", sequenceName = "COUNTRY_SEQ")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int countryCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country",cascade = CascadeType.ALL)
    private List<City> cityList = new ArrayList<>();

//    @OneToOne(mappedBy = "country")
//    private Address address;
}

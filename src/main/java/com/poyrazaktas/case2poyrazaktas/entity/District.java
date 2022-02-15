package com.poyrazaktas.case2poyrazaktas.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="DISTRICT")
@Data
public class District {
    @Id
    @GeneratedValue(generator = "District")
    @SequenceGenerator(name="District", sequenceName = "DISTRICT_SEQ")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "district")
    private List<Neighborhood> neighborhoodList = new ArrayList<Neighborhood>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_city")
    private City city;

    @OneToOne(mappedBy = "district")
    private Address address;
}

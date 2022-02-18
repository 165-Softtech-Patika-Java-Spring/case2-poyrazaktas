package com.poyrazaktas.case2poyrazaktas.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="NEIGHBORHOOD")
@Data
public class Neighborhood {
    @Id
    @GeneratedValue(generator = "Neighborhood")
    @SequenceGenerator(name = "Neighborhood", sequenceName = "NEIGHBORHOOD_SEQ")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "neighborhood")
    private List<Street> streetList=new ArrayList<Street>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_district")
    private District district;

//    @OneToOne(mappedBy = "neighborhood")
//    private Address address;
}

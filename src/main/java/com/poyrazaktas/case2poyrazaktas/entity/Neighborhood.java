package com.poyrazaktas.case2poyrazaktas.entity;

import lombok.Data;

import javax.persistence.*;

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
}

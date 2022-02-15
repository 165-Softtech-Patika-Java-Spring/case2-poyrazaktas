package com.poyrazaktas.case2poyrazaktas.entity;

import lombok.Data;

import javax.persistence.*;

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
}

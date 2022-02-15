package com.poyrazaktas.case2poyrazaktas.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="STREET")
@Data
public class Street {
    @Id
    @GeneratedValue(generator = "Street")
    @SequenceGenerator(name = "Street", sequenceName = "STREET_SEQ")
    private Long id;

    @Column(nullable = false)
    private String name;
}

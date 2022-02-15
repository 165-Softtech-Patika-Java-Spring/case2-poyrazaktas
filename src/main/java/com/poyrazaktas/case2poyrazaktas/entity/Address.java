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

    @Column(nullable = false)
    private String name;

    private int gateNumber;

    private int apartmentNumber;



}

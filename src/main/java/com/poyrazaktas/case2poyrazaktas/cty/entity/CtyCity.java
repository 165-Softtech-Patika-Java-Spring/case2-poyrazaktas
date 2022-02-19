package com.poyrazaktas.case2poyrazaktas.cty.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poyrazaktas.case2poyrazaktas.cnt.entity.CntCountry;
import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CITY")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","districtList"})
public class CtyCity {
    @Id
    @GeneratedValue(generator = "City")
    @SequenceGenerator(name="City",sequenceName = "CITY_SEQ")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int licensePlate;

    @OneToMany(fetch= FetchType.LAZY,mappedBy = "city",cascade = CascadeType.ALL)
    private List<DstDistrict> districtList = new ArrayList<DstDistrict>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id",nullable = false)
    private CntCountry country;

//    @OneToOne(mappedBy = "city")
//    private Address address;
}

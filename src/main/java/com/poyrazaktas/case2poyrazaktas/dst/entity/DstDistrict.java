package com.poyrazaktas.case2poyrazaktas.dst.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import com.poyrazaktas.case2poyrazaktas.ngh.entity.NghNeighborhood;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="DISTRICT")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","neighborhoodList"})
public class DstDistrict {
    @Id
    @GeneratedValue(generator = "District")
    @SequenceGenerator(name="District", sequenceName = "DISTRICT_SEQ")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "district",cascade = CascadeType.ALL)
    private List<NghNeighborhood> neighborhoodList = new ArrayList<NghNeighborhood>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_city")
    private CtyCity city;

//    @OneToOne(mappedBy = "district")
//    private Address address;
}

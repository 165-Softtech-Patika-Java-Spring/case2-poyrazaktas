package com.poyrazaktas.case2poyrazaktas.ngh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import com.poyrazaktas.case2poyrazaktas.srt.entity.SrtStreet;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "NEIGHBORHOOD")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "streetList"})
public class NghNeighborhood {
    @Id
    @GeneratedValue(generator = "Neighborhood")
    @SequenceGenerator(name = "Neighborhood", sequenceName = "NEIGHBORHOOD_SEQ")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "neighborhood", cascade = CascadeType.ALL)
    private List<SrtStreet> streetList = new ArrayList<SrtStreet>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_district")
    private DstDistrict district;

//    @OneToOne(mappedBy = "neighborhood")
//    private Address address;
}

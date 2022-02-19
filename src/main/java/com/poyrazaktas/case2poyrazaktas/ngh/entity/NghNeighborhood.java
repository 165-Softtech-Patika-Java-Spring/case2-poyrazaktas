package com.poyrazaktas.case2poyrazaktas.ngh.entity;

import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import com.poyrazaktas.case2poyrazaktas.srt.entity.SrtStreet;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="NEIGHBORHOOD")
@Data
public class NghNeighborhood {
    @Id
    @GeneratedValue(generator = "Neighborhood")
    @SequenceGenerator(name = "Neighborhood", sequenceName = "NEIGHBORHOOD_SEQ")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "neighborhood")
    private List<SrtStreet> streetList=new ArrayList<SrtStreet>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_district")
    private DstDistrict district;

//    @OneToOne(mappedBy = "neighborhood")
//    private Address address;
}

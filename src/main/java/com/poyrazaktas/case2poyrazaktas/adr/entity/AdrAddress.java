package com.poyrazaktas.case2poyrazaktas.adr.entity;

import com.poyrazaktas.case2poyrazaktas.cnt.entity.CntCountry;
import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import com.poyrazaktas.case2poyrazaktas.ngh.entity.NghNeighborhood;
import com.poyrazaktas.case2poyrazaktas.srt.entity.SrtStreet;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data
public class AdrAddress {
    @Id
    @GeneratedValue(generator = "Address")
    @SequenceGenerator(name="Address", sequenceName = "ADDRESS_SEQ")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="country_id",referencedColumnName = "id")
    private CntCountry country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="city_id",referencedColumnName = "id")
    private CtyCity city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="district_id",referencedColumnName = "id")
    private DstDistrict district;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="neighborhood_id",referencedColumnName = "id")
    private NghNeighborhood neighborhood;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="street_id",referencedColumnName = "id")
    private SrtStreet street;

    private int gateNumber;
    private int apartmentNumber;
}

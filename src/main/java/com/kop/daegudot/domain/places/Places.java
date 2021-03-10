package com.kop.daegudot.domain.places;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column
    private String address;
    @Column (length = 5000)
    private String attractContents;
    @Column
    private String attractName;
    @Column
    private String homepage;
    @Column
    private String telephone;
    @Column
    private Float longitude; //경도
    @Column
    private Float latitude; //위도



    @Builder
    public Places(String address, String attractContents, String attractName, String homepage,
                  String telephone) {
        this.address = address;
        this.attractContents = attractContents;
        this.attractName = attractName;
        this.homepage = homepage;
        this.telephone = telephone;
    }

    public void update(float longitude, float latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

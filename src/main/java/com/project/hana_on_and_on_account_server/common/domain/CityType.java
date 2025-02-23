package com.project.hana_on_and_on_account_server.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "city_type")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CityType extends BaseEntity {

    @Id
    @Column(name = "city_type_cd")
    private Integer cityTypeCd;

    @Column(name = "city_type_nm", length = 50)
    private String cityTypeNm;
}
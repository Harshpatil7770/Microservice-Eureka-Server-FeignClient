package com.xoriant.ecart.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "brand_name")
    private String brandName;

}
package com.itsuda.perfume.dto.request;

import com.itsuda.perfume.domain.type.BrandType;
import com.itsuda.perfume.domain.type.CountryType;
import com.itsuda.perfume.domain.type.GenderType;
import com.itsuda.perfume.domain.type.PotentialType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfumeRequestDto {
    private Integer price;
    private GenderType gender;
    private String accord;
    private PotentialType potential;
    private BrandType brand;
    private CountryType country;
}

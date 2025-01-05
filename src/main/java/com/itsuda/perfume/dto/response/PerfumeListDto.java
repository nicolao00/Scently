package com.itsuda.perfume.dto.response;

import com.itsuda.perfume.domain.Perfume;

public record PerfumeListDto(
        Long perfumeId,
        String name,
        String imageURL,
        String brand
) {
    public static PerfumeListDto from(Perfume perfume) {
        return new PerfumeListDto(perfume.getId(), perfume.getName(), perfume.getImageUri(), perfume.getBrand().getDescription());
    }
}
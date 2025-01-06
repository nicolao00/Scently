package com.itsuda.perfume.dto.response;

import com.itsuda.perfume.domain.Accord;
import com.itsuda.perfume.domain.Perfume;
import com.itsuda.perfume.domain.PerfumeDetail;
import com.itsuda.perfume.domain.PerfumeVolume;
import java.util.List;

public record PerfumeDetailDto(
        Long perfumeId,
        String imageURL,
        String brand,
        String name,
        List<PerfumeVolumeDto> perfumeVolumes,
        String potential,
        List<AccordDto> accords,
        String description, // 향 설명
        String detail // 상품 고시 정보
) {
    public static PerfumeDetailDto from(Perfume perfume, List<PerfumeVolume> perfumeVolumes, List<Accord> accords, PerfumeDetail perfumeDetail) {
        return new PerfumeDetailDto(
                perfume.getId(),
                perfume.getImageUri(),
                perfume.getBrand().getDescription(),
                perfume.getName(),
                PerfumeVolumeDto.from(perfumeVolumes),
                perfume.getPotential().getDescription(),
                AccordDto.from(accords),
                perfume.getDescription(),
                perfumeDetail.getContent()
        );
    }
}
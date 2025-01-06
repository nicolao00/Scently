package com.itsuda.perfume.dto.response;

import com.itsuda.perfume.domain.PerfumeVolume;
import java.util.List;

public record PerfumeVolumeDto(
        Long id,
        Integer volume,
        Integer price
) {
    public static List<PerfumeVolumeDto> from(List<PerfumeVolume> perfumeVolumes) {
        return perfumeVolumes.stream()
                .map(perfumeVolume -> new PerfumeVolumeDto(perfumeVolume.getId(), perfumeVolume.getVolume(), perfumeVolume.getPrice()))
                .toList();
    }
}

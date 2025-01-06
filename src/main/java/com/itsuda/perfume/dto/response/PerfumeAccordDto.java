package com.itsuda.perfume.dto.response;

import com.itsuda.perfume.domain.Accord;

public record PerfumeAccordDto(
        Long accordId,
        String name
) {
    public static PerfumeAccordDto from(Accord accord) {
        return new PerfumeAccordDto(accord.getId(), accord.getName());
    }
}

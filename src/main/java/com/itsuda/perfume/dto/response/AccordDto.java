package com.itsuda.perfume.dto.response;

import com.itsuda.perfume.domain.Accord;
import java.util.List;

public record AccordDto(
        Long id,
        String name
) {
    public static List<AccordDto> from(List<Accord> accords) {
        return accords.stream()
                .map(accord -> new AccordDto(accord.getId(), accord.getName()))
                .toList();
    }
}

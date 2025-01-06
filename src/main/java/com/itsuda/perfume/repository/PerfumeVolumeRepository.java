package com.itsuda.perfume.repository;

import com.itsuda.perfume.domain.Perfume;
import com.itsuda.perfume.domain.PerfumeVolume;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeVolumeRepository extends JpaRepository<PerfumeVolume, Long> {
    Optional<List<PerfumeVolume>> findByPerfume(Perfume perfume);
}

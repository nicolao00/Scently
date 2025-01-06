package com.itsuda.perfume.repository;

import com.itsuda.perfume.domain.Perfume;
import com.itsuda.perfume.domain.PerfumeVolume;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeVolumeRepository extends JpaRepository<PerfumeVolume, Long> {
     List<PerfumeVolume> findByPerfume(Perfume perfume);
}

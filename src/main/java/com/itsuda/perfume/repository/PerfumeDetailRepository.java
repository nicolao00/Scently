package com.itsuda.perfume.repository;

import com.itsuda.perfume.domain.Perfume;
import com.itsuda.perfume.domain.PerfumeDetail;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeDetailRepository extends JpaRepository<PerfumeDetail, Long> {
    Optional<PerfumeDetail> findByPerfume(Perfume perfume);
}

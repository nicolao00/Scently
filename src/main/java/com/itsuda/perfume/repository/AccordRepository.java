package com.itsuda.perfume.repository;

import com.itsuda.perfume.domain.Accord;
import com.itsuda.perfume.domain.Perfume;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccordRepository extends JpaRepository<Accord, Long> {
    @Query("SELECT DISTINCT a FROM Accord a " +
           "INNER JOIN PerfumeAccord pa ON pa.accord = a " +
           "WHERE pa.perfume = :perfume")
    Optional<List<Accord>> findAllByPerfume(@Param("perfume") Perfume perfume);
}
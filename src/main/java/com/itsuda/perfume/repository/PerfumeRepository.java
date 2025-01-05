package com.itsuda.perfume.repository;

import com.itsuda.perfume.domain.Perfume;
import com.itsuda.perfume.domain.PerfumeVolume;
import com.itsuda.perfume.domain.type.BrandType;
import com.itsuda.perfume.domain.type.CountryType;
import com.itsuda.perfume.domain.type.GenderType;
import com.itsuda.perfume.domain.type.PotentialType;
import com.itsuda.perfume.domain.PerfumeAccord;
import com.itsuda.perfume.domain.Accord;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Long> {

    // 향수 목록 조회
    // 프로젝트가 확장되거나 검색 옵션이 바뀌는 경우 QueryDSL로 전환하는게 좋을 듯?
    @Query("SELECT DISTINCT p FROM Perfume p " +
           "INNER JOIN p.perfumeVolumes pv " +
           "LEFT JOIN p.perfumeAccords pa " +
           "LEFT JOIN pa.accord a " +
           "WHERE " +
           "(:price IS NULL OR pv.price <= :price) AND " +
           "(:gender IS NULL OR p.gender = :gender) AND " +
           "(:accord IS NULL OR a.name = :accord) AND " +
           "(:potency IS NULL OR p.potential = :potency) AND " +
           "(:brand IS NULL OR p.brand = :brand) AND " +
           "(:country IS NULL OR p.country = :country)")
    List<Perfume> findBySearchOptions(
        @Param("price") Integer price, 
        @Param("gender") GenderType gender, 
        @Param("accord") String accord, 
        @Param("potency") PotentialType potency, 
        @Param("brand") BrandType brand, 
        @Param("country") CountryType country
    );
}

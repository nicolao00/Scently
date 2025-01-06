package com.itsuda.perfume.service;

import com.itsuda.perfume.dto.response.PerfumeAccordDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itsuda.perfume.dto.request.PerfumeRequestDto;
import com.itsuda.perfume.dto.response.PerfumeListDto;
import com.itsuda.perfume.repository.PerfumeRepository;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PerfumeService {
    private final PerfumeRepository perfumeRepository;
    private final AccordRepository accordRepository;

    // 향수 목록 조회
    public List<PerfumeListDto> getPerfumes(PerfumeRequestDto perfumeRequestDto) {
        return perfumeRepository.findBySearchOptions(
            perfumeRequestDto.getPrice(),
            perfumeRequestDto.getGender(),
            perfumeRequestDto.getAccord(),
            perfumeRequestDto.getPotential(),
            perfumeRequestDto.getBrand(),
            perfumeRequestDto.getCountry()
        ).stream().map(PerfumeListDto::from).toList();
    }

    // 향수 어코드 조회
    public List<PerfumeAccordDto> getAccords() {
        return accordRepository.findAll().stream().map(PerfumeAccordDto::from).toList();
    }

}

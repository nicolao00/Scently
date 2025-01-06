package com.itsuda.perfume.service;

import com.itsuda.perfume.domain.Accord;
import com.itsuda.perfume.domain.Perfume;
import com.itsuda.perfume.domain.PerfumeDetail;
import com.itsuda.perfume.domain.PerfumeVolume;
import com.itsuda.perfume.dto.response.PerfumeAccordDto;
import com.itsuda.perfume.dto.response.PerfumeDetailDto;
import com.itsuda.perfume.exception.ErrorCode;
import com.itsuda.perfume.exception.RestApiException;
import com.itsuda.perfume.repository.AccordRepository;
import com.itsuda.perfume.repository.PerfumeDetailRepository;
import com.itsuda.perfume.repository.PerfumeVolumeRepository;
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
    private final PerfumeVolumeRepository perfumeVolumeRepository;
    private final PerfumeDetailRepository perfumeDetailRepository;

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

    // 향수 상세 조회
    public PerfumeDetailDto getPerfumeDetail(Long perfumeId) {
        Perfume perfume = perfumeRepository.findById(perfumeId).orElseThrow(() -> new RestApiException(ErrorCode.NOT_FOUND_PERFUME));
         List<PerfumeVolume> perfumeVolume = perfumeVolumeRepository.findByPerfume(perfume);
         if (perfumeVolume.isEmpty()) {
             throw new RestApiException(ErrorCode.NOT_FOUND_PERFUME_VOLUME);
         }
         List<Accord> accords = accordRepository.findAllByPerfume(perfume);
         if (accords.isEmpty()) {
             throw new RestApiException(ErrorCode.NOT_FOUND_ACCORD);
         }
        PerfumeDetail perfumeDetail = perfumeDetailRepository.findByPerfume(perfume).orElseThrow(() -> new RestApiException(ErrorCode.NOT_FOUND_PERFUME_DETAIL));

        return PerfumeDetailDto.from(perfume, perfumeVolume, accords, perfumeDetail);
    }
}

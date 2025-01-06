package com.itsuda.perfume.controller;

import com.itsuda.perfume.dto.request.PerfumeRequestDto;
import com.itsuda.perfume.dto.response.PerfumeAccordDto;
import com.itsuda.perfume.dto.response.PerfumeListDto;
import com.itsuda.perfume.exception.ResponseDto;
import com.itsuda.perfume.service.PerfumeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Perfume", description = "향수 관련 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/perfumes")
public class PerfumeController {
    private final PerfumeService perfumeService;

    @Operation(summary = "향수 목록 조회", description = "조건에 맞는 향수 목록을 조회합니다.")
    @GetMapping("")
    public ResponseDto<List<PerfumeListDto>> getPerfumes(@ModelAttribute PerfumeRequestDto perfumeRequestDto) {
        return new ResponseDto<>(perfumeService.getPerfumes(perfumeRequestDto));
    }

    @Operation(summary = "향수 어코드 조회", description = "향수 어코드를 조회합니다.")
    @GetMapping("/accords")
    public ResponseDto<List<PerfumeAccordDto>> getAccords() {
        return new ResponseDto<>(perfumeService.getAccords());
    }
}

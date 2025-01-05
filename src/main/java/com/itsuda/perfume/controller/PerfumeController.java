package com.itsuda.perfume.controller;

import com.itsuda.perfume.dto.request.PerfumeRequestDto;
import com.itsuda.perfume.dto.response.PerfumeListDto;
import com.itsuda.perfume.exception.ResponseDto;
import com.itsuda.perfume.service.PerfumeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/perfumes")
public class PerfumeController {
    private final PerfumeService perfumeService;

    @GetMapping("")
    public ResponseDto<List<PerfumeListDto>> getPerfumes(@ModelAttribute PerfumeRequestDto perfumeRequestDto) {
        return new ResponseDto<>(perfumeService.getPerfumes(perfumeRequestDto));
    }
}

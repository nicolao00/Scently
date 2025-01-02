package com.itsuda.perfume.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Accord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String content;
    
    // ------------------------ 관계 설정 ----------------------------
    
    @OneToMany(mappedBy = "accord")
    private List<PerfumeAccord> perfumeAccords = new ArrayList<>();
} 
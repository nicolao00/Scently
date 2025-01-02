package com.itsuda.perfume.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;        // 국가 영문명
    
    @Column(nullable = false)
    private String nameKo;      // 국가 한글명

    // ------------------------ 관계 설정 ----------------------------
    @OneToMany(mappedBy = "country")
    private List<Perfume> perfumes = new ArrayList<>();
} 
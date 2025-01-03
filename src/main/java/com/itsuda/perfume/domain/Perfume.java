package com.itsuda.perfume.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.itsuda.perfume.domain.type.GenderType;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private String imageUri;
    
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    
    private String brand;
    
    private String potential;
    
    private String description; // 향 한줄 소개
    
    @Column(name = "registered_at")
    private LocalDate registeredAt;

    // ------------------------ 관계 설정 ----------------------------

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;
    
    @OneToMany(mappedBy = "perfume")
    private List<Review> reviews = new ArrayList<>();
    
    @OneToMany(mappedBy = "perfume")
    private List<WishPerfume> wishPerfumes = new ArrayList<>();
    
    @OneToMany(mappedBy = "perfume")
    private List<PerfumeAccord> perfumeAccords = new ArrayList<>();
    
    @OneToMany(mappedBy = "perfume")
    private List<PerfumeVolume> perfumeVolumes = new ArrayList<>();
    
    @OneToMany(mappedBy = "perfume")
    private List<PerfumeDetail> details = new ArrayList<>();
}


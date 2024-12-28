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
    
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    
    private String brand;
    
    private String price;
    
    private String potential;
    
    @Enumerated(EnumType.STRING)
    private Country country;
    
    private String description; // 향 한줄 소개
    
    @Column(name = "registered_at")
    private LocalDate registeredAt;

    // ------------------------ 관계 설정 ----------------------------
    
    @OneToMany(mappedBy = "perfume")
    private List<Review> reviews = new ArrayList<>();
    
    @OneToMany(mappedBy = "perfume")
    private List<WishPerfume> wishPerfumes = new ArrayList<>();
    
    @OneToMany(mappedBy = "perfume")
    private List<PerfumeNote> perfumeNotes = new ArrayList<>();
    
    @OneToMany(mappedBy = "perfume")
    private List<PerfumeVolume> perfumeVolumes = new ArrayList<>();
    
    @OneToMany(mappedBy = "perfume")
    private List<PerfumeDetail> details = new ArrayList<>();
}


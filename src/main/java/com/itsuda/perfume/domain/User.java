package com.itsuda.perfume.domain;

import com.itsuda.perfume.domain.type.GenderType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users") 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String nickname;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    private String username;
    
    @Column(unique = true)
    private String email;
    
    private String presentation;
    
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    // ------------------------ 관계 설정 ----------------------------
    
    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();
    
    @OneToMany(mappedBy = "customer")
    private List<WishPerfume> wishPerfumes = new ArrayList<>();
} 
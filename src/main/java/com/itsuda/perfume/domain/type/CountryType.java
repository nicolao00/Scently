package com.itsuda.perfume.domain.type;

public enum CountryType {
    FRANCE("프랑스"),
    ITALY("이탈리아"),
    USA("미국"),
    UK("영국"),
    KOREA("한국"),
    SWEDEN("스웨덴");
    
    private final String description;
    
    CountryType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
} 
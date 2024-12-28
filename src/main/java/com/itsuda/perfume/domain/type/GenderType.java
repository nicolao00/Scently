package com.itsuda.perfume.domain.type;

public enum GenderType {
    MALE("남성"),
    FEMALE("여성"),
    UNISEX("유니섹스"),
    UNKNOWN("알 수 없음");
    
    private final String description;
    
    GenderType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}

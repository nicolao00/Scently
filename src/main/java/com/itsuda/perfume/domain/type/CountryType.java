package com.itsuda.perfume.domain.type;

public enum CountryType {
    FRANCE("프랑스"),
    ITALY("이탈리아"),
    USA("미국"),
    UK("영국"),
    SWEDEN("스웨덴"),
    SWITZERLAND("스위스"),
    GERMANY("독일"),
    SPAIN("스페인"),
    NETHERLANDS("네덜란드"),
    BELGIUM("벨기에"),
    DENMARK("덴마크"),
    JAPAN("일본"),
    UAE("아랍에미리트"),
    KOREA("한국");
    
    private final String description;
    
    CountryType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
} 
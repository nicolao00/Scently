package com.itsuda.perfume.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ExceptionDto {
    private final String code;
    private final String message;

    // 사용자 정의 예외(ErrorCode Enum)에 따른 예외처리할 경우
    public ExceptionDto(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    // 그 외 Exception 에 따른 예외처리할 경우
    public ExceptionDto(Exception e) {
        this.code = "500";
        this.message = e.getMessage();
    }
}

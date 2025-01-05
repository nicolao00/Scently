package com.itsuda.perfume.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    NOT_FOUND_USER("4040", HttpStatus.NOT_FOUND, "Not Exist User"),
    NOT_FOUND_COMMENT("4045", HttpStatus.NOT_FOUND, "Not Exist Comment"),

    // Bad Request Error
    NOT_END_POINT("4000",HttpStatus.BAD_REQUEST , "Not Exist End Point Error"),
    DUPLICATION_TITLE("4003", HttpStatus.BAD_REQUEST, "Duplication Title"),
    DUPLICATION_NAME("4004", HttpStatus.BAD_REQUEST, "Duplication Name"),

    // Server, File Up/DownLoad Error
    SERVER_ERROR("5000", HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    FILE_UPLOAD("5001", HttpStatus.INTERNAL_SERVER_ERROR, "File Upload Fail"),
    FILE_DOWNLOAD("5002", HttpStatus.INTERNAL_SERVER_ERROR, "File Download Fail"),

    // Access Denied Error
    ACCESS_DENIED_ERROR("4010", HttpStatus.UNAUTHORIZED, "Access Denied Token Error"),

    // Token Error Set
    TOKEN_INVALID_ERROR("4011", HttpStatus.UNAUTHORIZED, "Invalid Token Error"),
    TOKEN_EXPIRED_ERROR("4013", HttpStatus.UNAUTHORIZED, "Expired Token Error"),
    TOKEN_TYPE_ERROR("4014", HttpStatus.UNAUTHORIZED, "Type Token Error"),
    TOKEN_UNSUPPORTED_ERROR("4015", HttpStatus.UNAUTHORIZED, "Unsupported Token Error"),
    TOKEN_UNKNOWN_ERROR("4016", HttpStatus.UNAUTHORIZED, "Unknown Error");


    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}

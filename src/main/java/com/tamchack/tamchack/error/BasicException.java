package com.tamchack.tamchack.error;

public class BasicException extends RuntimeException{

    private final ErrorCode errorCode;

    public BasicException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BasicException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}

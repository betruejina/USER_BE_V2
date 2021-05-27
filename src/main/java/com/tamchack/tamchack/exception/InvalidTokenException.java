package com.tamchack.tamchack.exception;

import com.tamchack.tamchack.error.BasicException;
import com.tamchack.tamchack.error.ErrorCode;

public class InvalidTokenException extends BasicException {

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }

}

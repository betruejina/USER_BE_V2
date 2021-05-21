package com.tamchack.tamchack.exception;

import com.tamchack.tamchack.error.BasicException;
import com.tamchack.tamchack.error.ErrorCode;

public class UserAlreadyEsixtsException extends BasicException {
    public UserAlreadyEsixtsException() {
        super(ErrorCode.USER_ALREADY_EXISTS_EXCEPTION);
    }
}

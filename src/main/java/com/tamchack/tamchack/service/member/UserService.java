package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.payload.request.UserSignUpRequest;

public interface UserService {
    void userSignUp(UserSignUpRequest userSignUpRequest);
}

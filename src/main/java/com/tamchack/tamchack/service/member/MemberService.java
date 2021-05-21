package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.payload.request.Member.RevisePasswordRequest;
import com.tamchack.tamchack.payload.request.Member.StoreuserSignUpRequest;
import com.tamchack.tamchack.payload.request.Member.UserSignUpRequest;

public interface MemberService {

    void userSignUp(UserSignUpRequest userSignUpRequest);

    void storeuserSignUp(StoreuserSignUpRequest storeuserSignUpRequest);

    void updateUserPassword(RevisePasswordRequest revisePasswordRequest, String token);

    void updateUserStoreuserPassword(RevisePasswordRequest revisePasswordRequest, String token);

}

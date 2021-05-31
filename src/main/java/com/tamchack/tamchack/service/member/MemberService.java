package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.dto.request.member.RevisePasswordRequest;
import com.tamchack.tamchack.dto.request.member.StoreuserSignUpRequest;
import com.tamchack.tamchack.dto.request.member.UserSignUpRequest;

public interface MemberService {

    void userSignUp(UserSignUpRequest userSignUpRequest);

    void storeuserSignUp(StoreuserSignUpRequest storeuserSignUpRequest);

    void updateUserPassword(RevisePasswordRequest revisePasswordRequest, String token);

    void updateUserStoreuserPassword(RevisePasswordRequest revisePasswordRequest, String token);

}

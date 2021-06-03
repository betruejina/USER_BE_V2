package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.dto.request.member.RevisePasswordRequest;
import com.tamchack.tamchack.dto.request.member.StoreuserSignUpRequest;
import com.tamchack.tamchack.dto.request.member.UserSignUpRequest;
import com.tamchack.tamchack.dto.response.address.ApplicationListResponse;
import org.springframework.data.domain.Pageable;

public interface MemberService {

    void userSignUp(UserSignUpRequest userSignUpRequest, StoreuserSignUpRequest storeuserSignUpRequest);

    void storeuserSignUp(StoreuserSignUpRequest storeuserSignUpRequest, UserSignUpRequest userSignUpRequest);

    void updateUserPassword(RevisePasswordRequest revisePasswordRequest, String token);

    void updateStoreuserPassword(RevisePasswordRequest revisePasswordRequest, String token);

    ApplicationListResponse getBookmarkList(String query, Pageable page);

}

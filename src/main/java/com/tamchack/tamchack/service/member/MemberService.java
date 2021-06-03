package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.dto.request.member.RevisePasswordRequest;
import com.tamchack.tamchack.dto.request.member.StoreuserSignUpRequest;
import com.tamchack.tamchack.dto.request.member.UserSignUpRequest;
import com.tamchack.tamchack.dto.response.address.ApplicationListResponse;
import com.tamchack.tamchack.dto.response.store.StoreResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {

    void userSignUp(UserSignUpRequest userSignUpRequest, StoreuserSignUpRequest storeuserSignUpRequest);

    void storeuserSignUp(StoreuserSignUpRequest storeuserSignUpRequest, UserSignUpRequest userSignUpRequest);

    void updateUserPassword(RevisePasswordRequest revisePasswordRequest, String token);

    void updateStoreuserPassword(RevisePasswordRequest revisePasswordRequest, String token);

    List<StoreResponse> getBookmarkList(String query);

}

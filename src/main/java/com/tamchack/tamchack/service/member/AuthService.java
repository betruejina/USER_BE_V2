package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.payload.request.Member.SignInRequest;
import com.tamchack.tamchack.payload.response.TokenResponse;

public interface AuthService {

    TokenResponse userSignIn(SignInRequest signInRequest);

    TokenResponse storeuserSignIn(SignInRequest signInRequest);

}

package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.payload.request.Member.SignInRequest;
import com.tamchack.tamchack.payload.response.TokenResponse;

public class AuthService {
    
    TokenResponse userSignIn(SignInRequest signInRequest);


}

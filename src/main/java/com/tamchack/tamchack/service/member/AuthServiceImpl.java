package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.security.token.JwtProvider;
import com.tamchack.tamchack.domain.member.Storeuser;
import com.tamchack.tamchack.domain.member.User;
import com.tamchack.tamchack.exception.UserNotFoundException;
import com.tamchack.tamchack.payload.request.Member.SignInRequest;
import com.tamchack.tamchack.payload.response.TokenResponse;
import com.tamchack.tamchack.repository.StoreuserRepository;
import com.tamchack.tamchack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final StoreuserRepository storeuserRepository;
    private final JwtProvider jwtProvider;

    @Override
    public TokenResponse userSignIn(SignInRequest signInRequest) {
        User user = userRepository.findByIdAndPassword(signInRequest.getId(), signInRequest.getPassword());
        if(user == null){
            throw new UserNotFoundException(); //수정
        }
        return createTokenResponse(user.getId());
    }

    @Override
    public TokenResponse storeuserSignIn(SignInRequest signInRequest) {
        Storeuser storeuser = storeuserRepository.findByIdAndPassword(signInRequest.getId(), signInRequest.getPassword());
        if(storeuser == null){
            throw new UserNotFoundException();
        }
        return createTokenResponse(storeuser.getId());
    }

    private TokenResponse createTokenResponse(String id) {
        String accessToken = jwtProvider.getAccessToken(id);
        String refreshToken = jwtProvider.getRefreshToken(id);
        return new TokenResponse(accessToken, refreshToken);
    }

}

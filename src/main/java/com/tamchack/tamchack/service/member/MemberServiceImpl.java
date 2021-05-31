package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.exception.UserNotFoundException;
import com.tamchack.tamchack.security.token.JWTProvider;
import com.tamchack.tamchack.domain.member.Storeuser;
import com.tamchack.tamchack.domain.member.User;
import com.tamchack.tamchack.domain.store.Store;
import com.tamchack.tamchack.exception.UserAlreadyEsixtsException;
import com.tamchack.tamchack.dto.request.member.RevisePasswordRequest;
import com.tamchack.tamchack.dto.request.member.StoreuserSignUpRequest;
import com.tamchack.tamchack.dto.request.member.UserSignUpRequest;
import com.tamchack.tamchack.repository.StoreRepository;
import com.tamchack.tamchack.repository.StoreuserRepository;
import com.tamchack.tamchack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final UserRepository userRepository;
    private final StoreuserRepository storeuserRepository;
    private final StoreRepository storeRepository;
    private final JWTProvider jwtProvider;

    @Override
    public void userSignUp(UserSignUpRequest userSignUpRequest) {

        userRepository.findById(userSignUpRequest.getId())
                .ifPresent(u -> {
                    throw new UserAlreadyEsixtsException();
                });

        userRepository.save(
                User.builder()
                        .id(userSignUpRequest.getId())
                        .password(userSignUpRequest.getPassword())
                        .name(userSignUpRequest.getName())
                        .build()
        );

    }

    @Override
    public void storeuserSignUp(StoreuserSignUpRequest storeuserSignUpRequest) {

        storeuserRepository.findById(storeuserSignUpRequest.getId())
                .ifPresent(u -> {
                    throw new UserAlreadyEsixtsException();
                });

        storeuserRepository.save(
                Storeuser.builder()
                            .id(storeuserSignUpRequest.getId())
                            .password(storeuserSignUpRequest.getPassword())
                            .build()
        );

        storeRepository.save(
                Store.builder()
                        .name(storeuserSignUpRequest.getStoreName())
                        .address(storeuserSignUpRequest.getStoreAddress())
                        .number(storeuserSignUpRequest.getStoreNumber())
                        .openingHours(storeuserSignUpRequest.getOpeningHours())
                        .build()
        );

    }

    @Override
    public void updateUserPassword(RevisePasswordRequest revisePasswordRequest, String token) {

        String password = revisePasswordRequest.getPassword();

        User user = userRepository.findById(jwtProvider.parseToken(token))
                .orElseThrow(UserNotFoundException::new);

        userRepository.save(user.update(password));
    }

    @Override
    public void updateUserStoreuserPassword(RevisePasswordRequest revisePasswordRequest, String token) {

        String password = revisePasswordRequest.getPassword();

        Storeuser storeuser = storeuserRepository.findById(jwtProvider.parseToken(token))
                .orElseThrow(UserNotFoundException::new);

        storeuserRepository.save(storeuser.update(password));
    }

}

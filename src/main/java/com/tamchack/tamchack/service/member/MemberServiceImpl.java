package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.JwtProvider;
import com.tamchack.tamchack.domain.member.Storeuser;
import com.tamchack.tamchack.domain.member.User;
import com.tamchack.tamchack.domain.store.Store;
import com.tamchack.tamchack.exception.UserAlreadyEsixtsException;
import com.tamchack.tamchack.payload.request.Member.RevisePasswordRequest;
import com.tamchack.tamchack.payload.request.Member.StoreuserSignUpRequest;
import com.tamchack.tamchack.payload.request.Member.UserSignUpRequest;
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
    private final JwtProvider jwtProvider;

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
                        .storeName(storeuserSignUpRequest.getStoreName())
                        .storeAddress(storeuserSignUpRequest.getStoreAddress())
                        .storeNumber(storeuserSignUpRequest.getStoreNumber())
                        .openingHours(storeuserSignUpRequest.getOpeningHours())
                        .build()
        );

    }

    @Override
    public void updateUserPassword(RevisePasswordRequest revisePasswordRequest, String token) {
        User user = userRepository.findByPassword(jwtProvider.parseToken(token));
        user.update(revisePasswordRequest.getPassword());
        userRepository.save(user);
    }

    @Override
    public void updateUserStoreuserPassword(RevisePasswordRequest revisePasswordRequest, String token) {
        Storeuser storeuser = storeuserRepository.findByPassword(jwtProvider.parseToken(token));
        storeuser.update(revisePasswordRequest.getPassword());
        storeuserRepository.save(storeuser);
    }
}

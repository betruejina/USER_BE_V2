package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.domain.member.User;
import com.tamchack.tamchack.payload.request.RevisePasswordRequest;
import com.tamchack.tamchack.payload.request.UserSignUpRequest;
import com.tamchack.tamchack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void userSignUp(UserSignUpRequest userSignUpRequest) {
        userRepository.save(
                User.builder()
                    .id(userSignUpRequest.getId())
                    .password(userSignUpRequest.getPassword())
                    .name(userSignUpRequest.getName())
                    .build()
        );

    }
}

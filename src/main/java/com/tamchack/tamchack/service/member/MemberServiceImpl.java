package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.domain.store.Bookmark;
import com.tamchack.tamchack.dto.request.store.BookmarkRequest;
import com.tamchack.tamchack.dto.response.address.ApplicationListResponse;
import com.tamchack.tamchack.dto.response.book.BookResponse;
import com.tamchack.tamchack.dto.response.bookmark.BookmarkResponse;
import com.tamchack.tamchack.dto.response.store.StoreResponse;
import com.tamchack.tamchack.exception.UserNotFoundException;
import com.tamchack.tamchack.repository.BookmarkRepository;
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
import org.springframework.boot.SpringApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final UserRepository userRepository;
    private final StoreuserRepository storeuserRepository;
    private final StoreRepository storeRepository;
    private final BookmarkRepository bookmarkRepository;
    private final JWTProvider jwtProvider;

    @Override
    public void userSignUp(UserSignUpRequest userSignUpRequest, StoreuserSignUpRequest storeuserSignUpRequest) {

        userRepository.findById(userSignUpRequest.getId())
                .ifPresent(u -> {
                    throw new UserAlreadyEsixtsException();
                });

        storeuserRepository.findById(storeuserSignUpRequest.getId())
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
    public void storeuserSignUp(StoreuserSignUpRequest storeuserSignUpRequest, UserSignUpRequest userSignUpRequest) {

        storeuserRepository.findById(storeuserSignUpRequest.getId())
                .ifPresent(u -> {
                    throw new UserAlreadyEsixtsException();
                });

        userRepository.findById(userSignUpRequest.getId())
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
                        .id(storeuserSignUpRequest.getStoreId())
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
    public void updateStoreuserPassword(RevisePasswordRequest revisePasswordRequest, String token) {

        String password = revisePasswordRequest.getPassword();

        Storeuser storeuser = storeuserRepository.findById(jwtProvider.parseToken(token))
                .orElseThrow(UserNotFoundException::new);

        storeuserRepository.save(storeuser.update(password));
    }

    @Override
    public List<StoreResponse> getBookmarkList(String query) {

        List<Bookmark> bookmarks =bookmarkRepository.findAllByUserId(query);

        List<StoreResponse> storeResponses = new ArrayList<>();

        for(Bookmark bookmark : bookmarks){
            Store store = bookmark.getStore();
            storeResponses.add(
                    StoreResponse.builder()
                            .storeId(store.getId())
                            .name(store.getName())
                            .openingHours(store.getOpeningHours())
                            .number(store.getNumber())
                            .build()
            );
        }

        return storeResponses;
    }
}

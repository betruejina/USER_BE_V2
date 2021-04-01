package com.tamchack.tamchack.service.member;

import com.tamchack.tamchack.domain.member.Storeuser;
import com.tamchack.tamchack.domain.store.Store;
import com.tamchack.tamchack.payload.request.StoreuserSignUpRequest;
import com.tamchack.tamchack.repository.StoreRepository;
import com.tamchack.tamchack.repository.StoreuserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreuserServiceImpl implements StoreuserService{


    private final StoreuserRepository storeuserRepository;
    private final StoreRepository storeRepository;

    @Override
    public void storeuserSignUp(StoreuserSignUpRequest storeuserSignUpRequest) {
        storeuserRepository.save(
                Storeuser.builder()
                    .id(storeuserSignUpRequest.getId())
                    .password(storeuserSignUpRequest.getPassword())
                    .name(storeuserSignUpRequest.getName())
                    .build()
        );
        storeRepository.save(
                Store.builder()
                    .storeName(storeuserSignUpRequest.getStoreName())
                    .storeAddress(storeuserSignUpRequest.getStoreAddress())
                    .build()
        );
    }
}

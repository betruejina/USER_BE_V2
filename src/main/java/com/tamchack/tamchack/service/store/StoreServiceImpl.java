package com.tamchack.tamchack.service.store;

import com.tamchack.tamchack.domain.store.Store;
import com.tamchack.tamchack.payload.response.ApplicationListResponse;
import com.tamchack.tamchack.payload.response.StoreResponse;
import com.tamchack.tamchack.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    /* @Override
    public void updateStoreInfo(ReviseStoreRequest reviseStoreRequest, String token) {

    } */

    @Override
    public ApplicationListResponse searchStore(String query, Pageable page) {
        Page<Store> storePage = storeRepository
                .findByAliStoreName(query, page);

        List<StoreResponse> storeResponses = new ArrayList<>();

        for(Store store : storePage){
            storeResponses.add(
                    StoreResponse.builder()
                            .name(store.getStoreName())
                            .address(store.getStoreAddress())
                            .number(store.getStoreNumber())
                            .openingHours(store.getOpeningHours())
                            .build()
            );
        }

        return ApplicationListResponse.builder()
                .totalElements((int)storePage.getTotalElements())
                .totalPages(storePage.getTotalPages())
                .applicationResponses(storeResponses)
                .build();
    }
}

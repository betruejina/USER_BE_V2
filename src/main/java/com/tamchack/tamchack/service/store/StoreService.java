package com.tamchack.tamchack.service.store;

import com.tamchack.tamchack.payload.response.ApplicationListResponse;
import org.springframework.data.domain.Pageable;

public interface StoreService {

    // void updateStoreInfo(ReviseStoreRequest reviseStoreRequest, String token);

    ApplicationListResponse searchStore(String query, Pageable page);
}

package com.tamchack.tamchack.service.store;

import com.tamchack.tamchack.dto.request.member.RevisePasswordRequest;
import com.tamchack.tamchack.dto.request.store.BookmarkRequest;
import com.tamchack.tamchack.dto.request.store.ReviseStoreRequest;
import com.tamchack.tamchack.dto.response.address.ApplicationListResponse;
import org.springframework.data.domain.Pageable;

public interface StoreService {

    void updateStoreInfo(ReviseStoreRequest reviseStoreRequest, String token);

    void bookmarkStore(BookmarkRequest bookmarkRequest);

    ApplicationListResponse searchStore(String query, Pageable page);

}

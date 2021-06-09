package com.tamchack.tamchack.dto.request.store;

import com.tamchack.tamchack.domain.store.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkRequest {

    private Store storeId;

    private String userId;

}

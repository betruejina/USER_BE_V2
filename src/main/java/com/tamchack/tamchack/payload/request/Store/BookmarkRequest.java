package com.tamchack.tamchack.payload.request.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkRequest {

    private Integer storeId;

    private Integer bookId;

}

package com.tamchack.tamchack.payload.request.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviseStoreRequest {

    private String storeNumber;

    private String openingHours;

}

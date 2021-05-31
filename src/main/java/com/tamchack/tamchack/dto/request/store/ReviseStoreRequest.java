package com.tamchack.tamchack.payload.request.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviseStoreRequest {

    private String storeNumber;

    private String openingHours;

}

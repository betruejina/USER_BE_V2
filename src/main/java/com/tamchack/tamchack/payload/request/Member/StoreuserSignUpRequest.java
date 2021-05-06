package com.tamchack.tamchack.payload.request.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreuserSignUpRequest {

    private String id;

    private String password;

    private String storeName;

    private String storeAddress;

    private String openingHours;

    private String storeNumber;

}

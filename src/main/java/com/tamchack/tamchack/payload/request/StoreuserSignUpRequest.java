package com.tamchack.tamchack.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreuserSignUpRequest {
    private String id;
    private String password;
    private String name;
    private String storeAddress;
    private String storeName;
}
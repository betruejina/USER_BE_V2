package com.tamchack.tamchack.payload.response.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreResponse {

    private Integer storeId;

    private String name;

    private String address;

    private String number;

    private String openingHours;

}

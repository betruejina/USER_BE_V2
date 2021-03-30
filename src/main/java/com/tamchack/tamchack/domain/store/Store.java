package com.tamchack.tamchack.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbl_store")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    private int id;

    private String storeName;

    private String storeAddress;

    private String storeNumber;

    private String openingHours;

    public Store changeOption(String storeNumber, String openingHours){
        this.storeNumber = storeNumber;
        this.openingHours = openingHours;
        return this;
    }

}

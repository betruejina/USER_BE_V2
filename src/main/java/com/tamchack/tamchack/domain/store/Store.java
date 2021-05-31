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

    private String storeuserId;

    private String name;

    private String address;

    private String number;

    private String openingHours;

    public Store changeOption(String number, String openingHours) {
        this.number = number;
        this.openingHours = openingHours;
        return this;
    }

}

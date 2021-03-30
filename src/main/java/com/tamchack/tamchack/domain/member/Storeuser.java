package com.tamchack.tamchack.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbl_storeuser")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Storeuser {

    @Id
    private String id;

    private String password;

    private String name;

    public Storeuser update (String password){
        this.password = password;
        return this;
    }

}

package com.tamchack.tamchack.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "tbl_bookmark")
@Getter
@Builder
@IdClass(BookmarkKey.class)
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {

    @Id
    private String userId;

    @Id
    private int storeId;

}

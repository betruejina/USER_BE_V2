package com.tamchack.tamchack.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

}

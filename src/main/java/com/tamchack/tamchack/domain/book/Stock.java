package com.tamchack.tamchack.domain.book;

import com.tamchack.tamchack.domain.store.BookmarkKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "tbl_stock")
@Getter
@Builder
@IdClass(StockKey.class)
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    private int storeId;

    @Id
    private int bookId;

}

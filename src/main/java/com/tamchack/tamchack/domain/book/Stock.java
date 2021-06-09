package com.tamchack.tamchack.domain.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

}

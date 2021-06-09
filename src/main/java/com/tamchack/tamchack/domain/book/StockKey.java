package com.tamchack.tamchack.domain.book;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class StockKey implements Serializable {

    private int storeId;

    private Book book;

}

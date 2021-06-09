package com.tamchack.tamchack.dto.response.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockResponse {

    private String bookName;

    private String author;

    private String publisher;

    private boolean stock;

}

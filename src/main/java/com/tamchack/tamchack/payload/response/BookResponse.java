package com.tamchack.tamchack.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    private Integer bookId;

    private String name;

    private String author;

    private String publisher;

}

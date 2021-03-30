package com.tamchack.tamchack.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String bookName;
    private String author;
    private String publisher;
}

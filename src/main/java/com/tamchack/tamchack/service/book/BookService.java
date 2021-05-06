package com.tamchack.tamchack.service.book;

import com.tamchack.tamchack.payload.request.Book.BookRequest;
import com.tamchack.tamchack.payload.response.ApplicationListResponse;
import org.springframework.data.domain.Pageable;

public interface BookService {

    void inPutBook(BookRequest bookRequest);

    ApplicationListResponse searchBook(String query, Pageable page);

    ApplicationListResponse searchBookInStore(Integer storeId, String query, Pageable page);
}

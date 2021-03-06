package com.tamchack.tamchack.service.book;

import com.tamchack.tamchack.dto.request.book.BookRequest;
import com.tamchack.tamchack.dto.request.book.StockRequest;
import com.tamchack.tamchack.dto.request.store.BookmarkRequest;
import com.tamchack.tamchack.dto.response.address.ApplicationListResponse;
import org.springframework.data.domain.Pageable;

public interface BookService {

    void inputBook(BookRequest bookRequest);

    void bookStock(StockRequest stockRequest);

    ApplicationListResponse searchBook(String query, Pageable page);

    ApplicationListResponse searchBookInStore(Integer storeId, String query, Pageable page);
}

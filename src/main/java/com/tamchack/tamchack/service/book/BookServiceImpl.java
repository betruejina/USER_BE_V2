package com.tamchack.tamchack.service.book;

import com.tamchack.tamchack.domain.book.Book;
import com.tamchack.tamchack.dto.request.book.BookRequest;
import com.tamchack.tamchack.dto.response.address.ApplicationListResponse;
import com.tamchack.tamchack.dto.response.book.BookResponse;
import com.tamchack.tamchack.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Override
    public void inPutBook(BookRequest bookRequest) {

        Book book = bookRepository.save(
                Book.builder()
                        .name(bookRequest.getBookName())
                        .author(bookRequest.getAuthor())
                        .publisher(bookRequest.getPublisher())
                        .build()
        );

        String fileName = String.valueOf(book.getId());
    }

    @Override
    public ApplicationListResponse searchBook(String query, Pageable page) {
        return getApplications(bookRepository
                .findAllByNameContains(query, page));
    }

    @Override
    public ApplicationListResponse searchBookInStore(Integer storeId, String query, Pageable page) {
        return getApplications(bookRepository
                .findAllByStoreIdAndNameContains(storeId, query, page));
    }

    private ApplicationListResponse getApplications(Page<Book> bookPage) {

        List<BookResponse> bookResponses = new ArrayList<>();

        for(Book book : bookPage){
            bookResponses.add(
                    BookResponse.builder()
                            .name(book.getName())
                            .author(book.getAuthor())
                            .publisher(book.getPublisher())
                            .build()
            );
        }

        return ApplicationListResponse.builder()
                .totalElements((int)bookPage.getTotalElements())
                .totalPages(bookPage.getTotalPages())
                .applicationResponses(bookResponses)
                .build();
    }

}
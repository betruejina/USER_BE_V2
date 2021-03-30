package com.tamchack.tamchack.repository;

import com.tamchack.tamchack.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, String> {
}

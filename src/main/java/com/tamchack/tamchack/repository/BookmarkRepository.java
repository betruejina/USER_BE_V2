package com.tamchack.tamchack.repository;

import com.tamchack.tamchack.domain.store.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, String> {

    boolean existsByStoreIdAndUserId(Integer storeId, String userId);

    void deleteByStoreIdAndUserId(Integer storeId, String userId);

    Page<Bookmark> findAllByUserId(String userId, Pageable page);

}

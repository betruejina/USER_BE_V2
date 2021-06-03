package com.tamchack.tamchack.repository;

import com.tamchack.tamchack.domain.store.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, String> {

    boolean existsByStoreIdAndUserId(Integer storeId, String userId);

    void deleteByStoreIdAndUserId(Integer storeId, String userId);

    List<Bookmark> findAllByUserId(String userId);

}

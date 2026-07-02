package org.scoula.carrotmarket.wishlist.service;

import org.scoula.carrotmarket.wishlist.dto.WishlistDTO;

import java.util.List;

public interface WishlistService {

    // 전체 찜 목록 조회
    List<WishlistDTO> getList();

    // 특정 사용자의 찜 목록 조회
    List<WishlistDTO> getListByUser(Integer userId);

    // 찜 상세 조회
    WishlistDTO get(Integer wishlistId);

    // 찜 등록
    void create(WishlistDTO wishlist);

    // 찜 수정
    boolean update(WishlistDTO wishlist);

    // 찜 삭제
    boolean delete(Integer wishlistId);
}
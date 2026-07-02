package org.scoula.carrotmarket.wishlist.mapper;

import org.scoula.carrotmarket.wishlist.domain.WishlistVO;

import java.util.List;

public interface WishlistMapper {

    // 전체 찜 목록 조회
    List<WishlistVO> getList();

    // 특정 사용자의 찜 목록 조회
    List<WishlistVO> getListByUser(Integer userId);

    // 찜 상세 조회
    WishlistVO get(Integer wishlistId);

    // 찜 등록
    void create(WishlistVO wishlist);

    // 찜 수정
    int update(WishlistVO wishlist);

    // 찜 삭제
    int delete(Integer wishlistId);

}
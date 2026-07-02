package org.scoula.carrotmarket.wishlist.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.carrotmarket.wishlist.domain.WishlistVO;
import org.scoula.carrotmarket.wishlist.dto.WishlistDTO;
import org.scoula.carrotmarket.wishlist.mapper.WishlistMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class WishlistImpl implements WishlistService {

    private final WishlistMapper mapper;

    // 전체 찜 목록 조회
    @Override
    public List<WishlistDTO> getList() {
        return mapper.getList()
                .stream()
                .map(WishlistDTO::of)
                .toList();
    }

    // 특정 사용자의 찜 목록 조회
    @Override
    public List<WishlistDTO> getListByUser(Integer userId) {
        return mapper.getListByUser(userId)
                .stream()
                .map(WishlistDTO::of)
                .toList();
    }

    // 상세 조회
    @Override
    public WishlistDTO get(Integer wishlistId) {
        log.info("WishlistService get() 호출됨...");
        WishlistVO vo = mapper.get(wishlistId);
        return WishlistDTO.of(vo);
    }

    // 등록
    @Override
    public void create(WishlistDTO wishlist) {
        log.info("WishlistService create() 호출됨..." + wishlist);

        WishlistVO vo = wishlist.toVo();

        mapper.create(vo);

        wishlist.setWishlistId(vo.getWishlistId());
    }

    // 수정
    @Override
    public boolean update(WishlistDTO wishlist) {
        log.info("WishlistService update() 호출됨..." + wishlist);

        return mapper.update(wishlist.toVo()) == 1;
    }

    // 삭제
    @Override
    public boolean delete(Integer wishlistId) {
        log.info("WishlistService delete() 호출됨..." + wishlistId);

        return mapper.delete(wishlistId) == 1;
    }
}
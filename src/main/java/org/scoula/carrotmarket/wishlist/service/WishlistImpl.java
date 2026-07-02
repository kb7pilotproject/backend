package org.scoula.carrotmarket.wishlist.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.carrotmarket.wishlist.domain.WishlistVO;
import org.scoula.carrotmarket.wishlist.dto.WishlistDTO;
import org.scoula.carrotmarket.wishlist.mapper.WishlistMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2

public class WishlistImpl implements WishlistService {

    private final WishlistMapper mapper;

    @Override
    public WishlistDTO get(Integer wishlistId) {
        log.info("WishlistService get() 호출됨...");
        WishlistVO vo = mapper.get(wishlistId);
        return WishlistDTO.of(vo);
    }

    @Override
    public void create(WishlistDTO wishlist) {
        log.info("WishlistService create() 호출됨..." + wishlist);
        WishlistVO vo = wishlist.toVo();
        mapper.create(vo);
        wishlist.setWishlistId(vo.getWishlistId());
    }

    @Override
    public boolean update(WishlistDTO wishlist) {
        log.info("WishlistService update() 호출됨..." + wishlist);
        return mapper.update(wishlist.toVo()) == 1;
    }

    @Override
    public boolean delete(Integer wishlistId) {
        log.info("WishlistService delete() 호출됨..." + wishlistId);
        return mapper.delete(wishlistId) == 1;
    }
}
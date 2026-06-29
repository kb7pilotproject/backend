package org.scoula.carrotmarket.wishlist.service;

import org.scoula.carrotmarket.wishlist.dto.WishlistDTO;

public interface WishlistService {
    Object get(Integer wishlistId);
    void create(WishlistDTO wishlist);
    boolean update(WishlistDTO wishlist);
    boolean delete(Integer wishlistId);
}

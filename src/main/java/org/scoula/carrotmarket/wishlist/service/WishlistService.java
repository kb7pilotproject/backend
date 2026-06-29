package org.scoula.carrotmarket.wishlist.service;

<<<<<<< HEAD
public interface WishlistService {
=======
import org.scoula.carrotmarket.wishlist.dto.WishlistDTO;

public interface WishlistService {
    Object get(Integer wishlistId);
    void create(WishlistDTO wishlist);
    boolean update(WishlistDTO wishlist);
    boolean delete(Integer wishlistId);
>>>>>>> 2f65b79ac5946ca1434dc07d956114c2dc313026
}

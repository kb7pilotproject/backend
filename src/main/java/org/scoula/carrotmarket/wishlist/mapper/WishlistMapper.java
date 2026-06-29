package org.scoula.carrotmarket.wishlist.mapper;

<<<<<<< HEAD
public class WishlistMapper {
=======
import org.scoula.carrotmarket.wishlist.domain.WishlistVO;
import java.util.List;

public interface WishlistMapper {

    public abstract List<WishlistVO> getList();

    // 상세 조회
    WishlistVO get(Integer wishlistId);

    // 찜 등록
    void create(WishlistVO wishlist);

    // 찜 수정
    int update(WishlistVO wishlist);

    // 찜 삭제
    int delete(Integer wishlistId);
>>>>>>> 2f65b79ac5946ca1434dc07d956114c2dc313026
}

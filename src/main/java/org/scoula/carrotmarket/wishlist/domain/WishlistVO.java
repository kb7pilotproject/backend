package org.scoula.carrotmarket.wishlist.domain;

<<<<<<< HEAD
public class WishlistVO {
=======
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishlistVO {
    private Integer wishlistId;
    private Integer userId;
    private Integer productId;
    private Date createdAt;
>>>>>>> 2f65b79ac5946ca1434dc07d956114c2dc313026
}

package org.scoula.carrotmarket.wishlist.domain;

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
}

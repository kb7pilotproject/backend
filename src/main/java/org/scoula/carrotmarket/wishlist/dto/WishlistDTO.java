package org.scoula.carrotmarket.wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.carrotmarket.wishlist.domain.WishlistVO;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class WishlistDTO {
    private Integer wishlistId;
    private Integer userId;
    private Integer productId;
    private Date createdAt;

    //dto --> vo
    public WishlistVO toVo(){
        return WishlistVO.builder()
                .wishlistId(wishlistId)
                .userId(userId)
                .productId(productId)
                .createdAt(createdAt)
                .build();
    }

    //vo --> dto
    public static WishlistDTO of(WishlistVO vo){

        return vo == null ? null : WishlistDTO.builder()
                                   .wishlistId(vo.getWishlistId())
                                   .userId(vo.getUserId())
                                   .productId(vo.getProductId())
                                   .createdAt(vo.getCreatedAt())
                                   .build();

    }
}

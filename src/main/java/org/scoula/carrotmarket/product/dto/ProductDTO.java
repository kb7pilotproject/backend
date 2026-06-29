package org.scoula.carrotmarket.product.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.scoula.carrotmarket.product.domain.ProductVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {


    private Long productId;
    private Long userId;
    private String title;
    private int price;
    private String imageUrl;
    private String category;
    private String description;
    private String status;
    private LocalDateTime createdAt;


    public ProductVO toVo() {
        return ProductVO.builder()
                .productId(this.productId)
                .userId(this.userId)
                .title(this.title)
                .price(this.price)
                .imageUrl(this.imageUrl)
                .category(this.category)
                .description(this.description)
                .status(this.status)
                .createdAt(this.createdAt)
                .build();
    }


    public static ProductDTO of(ProductVO vo) {
        return vo == null ? null : ProductDTO.builder()
                                   .productId(vo.getProductId())
                                   .userId(vo.getUserId())
                                   .title(vo.getTitle())
                                   .price(vo.getPrice())
                                   .imageUrl(vo.getImageUrl())
                                   .category(vo.getCategory())
                                   .description(vo.getDescription())
                                   .status(vo.getStatus())
                                   .createdAt(vo.getCreatedAt())
                                   .build();
    }
}
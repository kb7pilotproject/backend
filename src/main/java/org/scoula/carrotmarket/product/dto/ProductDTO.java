package org.scoula.carrotmarket.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.carrotmarket.product.domain.ProductVO;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long productId;
    private Long userId;

    private String title;
    private Integer price;
    private String imageUrl;
    private String category;
    private String description;
    private String status;

    private LocalDateTime createdAt;

    // DTO -> VO
    public ProductVO toVo() {
        return ProductVO.builder()
                .productId(productId)
                .userId(userId)
                .title(title)
                .price(price)
                .imageUrl(imageUrl)
                .category(category)
                .description(description)
                .status(status)
                .createdAt(createdAt)
                .build();
    }

    // VO -> DTO
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
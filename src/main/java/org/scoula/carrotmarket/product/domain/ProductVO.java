package org.scoula.carrotmarket.product.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVO {
    private Long productId;
    private Long userId;

    private String title;
    private Integer price;
    private String imageUrl;
    private String category;
    private String description;
    private String status;

    private LocalDateTime createdAt;
}

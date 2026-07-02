package org.scoula.carrotmarket.product.domain;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVO {

    private Long productId;
    private Long userId;
    private String title;
    private int price;
    private String imageUrl;
    private String category;
    private String description;
    private String status;
    private LocalDateTime createdAt;

}
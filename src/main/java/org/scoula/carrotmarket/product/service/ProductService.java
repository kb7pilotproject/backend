package org.scoula.carrotmarket.product.service;

import org.scoula.carrotmarket.product.domain.ProductVO;
import org.scoula.carrotmarket.product.dto.ProductDTO;
import java.util.List;

public interface ProductService {

    // 상품 등록
    void insert(ProductDTO product);

    // 상품 단건 조회
    ProductVO select(Long productId);

    //  상품 전체 목록 조회
    List<ProductVO> selectAll();

    //  상품 수정
    void update(ProductDTO product);

    //  상품 삭제
    void delete(ProductDTO product);
}
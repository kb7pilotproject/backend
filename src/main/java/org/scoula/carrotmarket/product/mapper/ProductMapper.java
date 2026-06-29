package org.scoula.carrotmarket.product.mapper;

import org.scoula.carrotmarket.product.domain.ProductVO;
import java.util.List;

public interface ProductMapper {

    // 상품 등록
    void insert(ProductVO product);

    // 상품 전체 목록 조회
    List<ProductVO> getList();

    // 특정 상품 상세 조회
    ProductVO read(Long productId);

    // 상품 수정
    int update(ProductVO product);

    // 상품 삭제
    int delete(Long productId);
}
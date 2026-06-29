package org.scoula.carrotmarket.product.service;

import lombok.RequiredArgsConstructor;
import org.scoula.carrotmarket.product.domain.ProductVO;
import org.scoula.carrotmarket.product.dto.ProductDTO;
import org.scoula.carrotmarket.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public void insert(ProductDTO product) {
        productMapper.insert(product.toVo());
    }

    @Override
    public ProductVO select(Long productId) {
        return productMapper.read(productId);
    }

    @Override
    public List<ProductVO> selectAll() {
        return productMapper.getList();
    }

    @Override
    public void update(ProductDTO product) {
        productMapper.update(product.toVo());
    }

    @Override
    public void delete(ProductDTO product) {
        productMapper.delete(product.toVo().getProductId());
    }
}
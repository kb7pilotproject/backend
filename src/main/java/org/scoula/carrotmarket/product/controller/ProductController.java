package org.scoula.carrotmarket.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.carrotmarket.product.domain.ProductVO;
import org.scoula.carrotmarket.product.dto.ProductDTO;
import org.scoula.carrotmarket.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Log4j2
public class ProductController {

    private final ProductService productService;

    // 상품 등록
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ProductDTO product) {
        log.info("insert product : " + product);
        productService.insert(product);
        return ResponseEntity.ok().build();
    }
    // 상품 전체 목록 조회
    @GetMapping
    public ResponseEntity<List<ProductVO>> selectAll() {
        log.info("selectAll products");
        List<ProductVO> list = productService.selectAll();
        return ResponseEntity.ok(list);
    }
    // 상품 상세 조회
    @GetMapping("/{productId}")
    public ResponseEntity<ProductVO> select(@PathVariable Long productId) {
        log.info("select product : " + productId);
        ProductVO product = productService.select(productId);
        return ResponseEntity.ok(product);
    }
    // 상품 수정
    @PutMapping("/{productId}")
    public ResponseEntity<Void> update(@PathVariable Long productId, @RequestBody ProductDTO product) {
        log.info("update product : " + product);
        product.setProductId(productId);
        productService.update(product);
        return ResponseEntity.ok().build();
    }
    // 상품 삭제
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable Long productId, @RequestBody ProductDTO product) {
        log.info("delete product : " + productId);
        product.setProductId(productId);
        productService.delete(product);
        return ResponseEntity.ok().build();
    }
}
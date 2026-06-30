package org.scoula.carrotmarket.comment.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.carrotmarket.comment.domain.CommentVO;
import org.scoula.carrotmarket.comment.dto.CommentDTO;
import org.scoula.carrotmarket.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Log4j2

public class CommentController {
    private final CommentService commentService;

    // 댓글 생성
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CommentDTO comment) {
        log.info("insert comment : " + comment);
        commentService.insert(comment);
        return ResponseEntity.ok().build();
    }

    // 댓글 조회
    @GetMapping("/{commentId}")
    public ResponseEntity<CommentVO> select(@PathVariable int commentId){
        log.info("select comment : " + commentId);
        return ResponseEntity.ok(commentService.select(commentId));
    }

    // 상품에 맞는 댓글 조회
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<CommentVO>> selectByProductId(@PathVariable int productId){
        log.info("select comments by ProductId : " + productId);
        return ResponseEntity.ok(commentService.selectByProductId(productId));
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<Void> update(@PathVariable int commentId, @RequestBody CommentDTO comment){
        log.info("update comment : " + comment);
        commentService.update(comment);
        return ResponseEntity.ok().build();
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> delete(@PathVariable int commentId, @RequestBody CommentDTO comment){
        log.info("delete comment : " + commentId);
        commentService.delete(comment);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/product/{productId}/count")
    public ResponseEntity<Integer> countByProductId(@PathVariable int productId){
        log.info("count comments by productId " + productId);
        return ResponseEntity.ok(commentService.countByProductId(productId));
    }

}

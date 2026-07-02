package org.scoula.carrotmarket.comment.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.carrotmarket.comment.domain.CommentVO;
import org.scoula.carrotmarket.comment.dto.CommentDTO;
import org.scoula.carrotmarket.comment.service.CommentService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<CommentVO> insert(@RequestBody CommentDTO comment) {
        log.info("insert comment : " + comment);
        CommentVO created = commentService.insert(comment);
        return ResponseEntity.ok(created);
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
    public ResponseEntity<String> update(@PathVariable int commentId, @RequestBody CommentDTO comment){
        log.info("update comment : " + comment);
        commentService.update(comment);
        return ResponseEntity.ok("Success");
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> delete(@PathVariable int commentId, @RequestBody CommentDTO comment){
        log.info("delete comment : " + commentId);
        boolean deleted = commentService.delete(comment);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 댓글입니다");
        }
        return ResponseEntity.ok("댓글 삭제 성공");
    }

    @GetMapping("/product/{productId}/count")
    public ResponseEntity<Integer> countByProductId(@PathVariable int productId){
        log.info("count comments by productId " + productId);
        return ResponseEntity.ok(commentService.countByProductId(productId));
    }

}

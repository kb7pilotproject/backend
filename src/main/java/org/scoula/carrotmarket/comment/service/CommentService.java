package org.scoula.carrotmarket.comment.service;

import org.scoula.carrotmarket.comment.domain.CommentVO;
import org.scoula.carrotmarket.comment.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    // 댓글 등록
    CommentVO insert(CommentDTO comment);

    // 댓글 단건 조회
    CommentVO select(int commentId);

    // 특정 상품에 달린 댓글 목록 조회
    List<CommentVO> selectByProductId(int productId);

    // 댓글 수정
    void update(CommentDTO comment);

    // 댓글 삭제
    boolean delete(CommentDTO comment);

    // 특정 상품의 댓글 수 카운트
    int countByProductId(int productId);

}

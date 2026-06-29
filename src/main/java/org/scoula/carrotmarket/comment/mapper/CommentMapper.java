package org.scoula.carrotmarket.comment.mapper;

import java.util.List;
import org.scoula.carrotmarket.comment.domain.CommentVO;

public interface CommentMapper {

    // 댓글 등록
    void insert(CommentVO comment);

    // 댓글 단건 조회
    CommentVO select(int commentId);

    // 특정 user가 작성한 댓글 목록 조회
    List<CommentVO> selectByProductId(int productId);

    // 댓글 수정
    void update(CommentVO comment);

    // 댓글 삭제
    void delete(CommentVO comment);

    // 특정 상품의 댓글 수 카운트
    int countByProductId(int productId);

}

package org.scoula.carrotmarket.comment.service;

import lombok.RequiredArgsConstructor;
import org.scoula.carrotmarket.comment.domain.CommentVO;
import org.scoula.carrotmarket.comment.dto.CommentDTO;
import org.scoula.carrotmarket.comment.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    public CommentVO insert(CommentDTO comment) {  // 반환타입 void → CommentVO
        CommentVO vo = comment.toVo();
        commentMapper.insert(vo);   // insert 후 vo.commentId에 생성된 ID가 채워짐
        return commentMapper.select(vo.getCommentId());
    }

    @Override
    public CommentVO select(int commentId) {
        return commentMapper.select(commentId);
    }

    @Override
    public List<CommentVO> selectByProductId(int productId) {
        return commentMapper.selectByProductId(productId);
    }

    @Override
    public void update(CommentDTO comment) {
        commentMapper.update(comment.toVo());
    }

    @Override
    public boolean delete(CommentDTO comment) {
        int result = commentMapper.delete(comment.toVo());
        return result > 0;
    }

    @Override
    public int countByProductId(int productId) {
        return commentMapper.countByProductId(productId);
    }

}
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
    public void insert(CommentDTO comment) {
        commentMapper.insert(comment.toVo());
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
    public void delete(CommentDTO comment) {
        commentMapper.delete(comment.toVo());
    }

    @Override
    public int countByProductId(int productId) {
        return commentMapper.countByProductId(productId);
    }

}
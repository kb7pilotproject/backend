package org.scoula.carrotmarket.comment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.carrotmarket.comment.domain.CommentVO;
import org.scoula.carrotmarket.comment.dto.CommentDTO;
import org.scoula.carrotmarket.comment.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Log4j2
public class CommentServiceImpl implements CommentService {


    private final CommentMapper commentMapper;

    @Override
    public void insert(CommentDTO comment) {

    }

    @Override
    public CommentVO select(int commentId) {
        return null;
    }

    @Override
    public List<CommentVO> selectByProductId(int productId) {
        return List.of();
    }

    @Override
    public void update(CommentDTO comment) {
        CommentVO vo = comment.toVo();
        commentMapper.update(comment.toVo());
    }

    @Override
    public void delete(CommentDTO comment) {
        CommentVO vo = comment.toVo();
        commentMapper.delete(comment.toVo());
    }

    @Override
    public int countByProductId(int productId) {
        return 0;
    }
}

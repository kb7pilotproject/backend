package org.scoula.carrotmarket.comment.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.carrotmarket.comment.domain.CommentVO;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private int commentId;
    private int productId;
    private int userId;
    private String content;
    private Timestamp createdAt;

    public CommentVO toVo() {
        return CommentVO.builder()
                .commentId(commentId)
                .productId(productId)
                .userId(userId)
                .content(content)
                .createdAt(createdAt)
                .build();

    }

    public static CommentDTO of(CommentVO vo) {

        return vo == null ? null : CommentDTO.builder()
                .commentId(vo.getCommentId())
                .productId(vo.getProductId())
                .userId(vo.getUserId())
                .content(vo.getContent())
                .createdAt(vo.getCreatedAt())
                .build();
    }

}

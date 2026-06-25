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
    private int CommentId;
    private int ProductId;
    private int UserId;
    private String content;
    private Timestamp CreatedAt;

    public CommentVO toVo() {
        return CommentVO.builder()
                .CommentId(CommentId)
                .ProductId(ProductId)
                .UserId(UserId)
                .content(content)
                .CreatedAt(CreatedAt)
                .build();

    }

    public static CommentDTO of(CommentVO vo) {

        return vo == null ? null : CommentDTO.builder()
                .CommentId(vo.getCommentId())
                .ProductId(vo.getProductId())
                .UserId(vo.getUserId())
                .content(vo.getContent())
                .CreatedAt(vo.getCreatedAt())
                .build();
    }

}

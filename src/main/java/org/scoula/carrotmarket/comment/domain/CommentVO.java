package org.scoula.carrotmarket.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CommentVO {
    private int commentId;
    private int productId;
    private int userId;
    private String content;
    private Timestamp createdAt;
}

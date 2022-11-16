package springJpa.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PostCommentDTO {

    private Long commentId;
    private String content;
    private LocalDateTime createdAt;

    private List<CommentDTO> comments;

    public Long getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public PostCommentDTO() {
    }

    public PostCommentDTO(Long commentId, String content, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
    }
}

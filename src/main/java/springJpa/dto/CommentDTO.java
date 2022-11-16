package springJpa.dto;

import java.time.LocalDateTime;

public class CommentDTO {

    private Long commentId;
    private String content;
    private LocalDateTime createdAt;

    private CommentUserDTO commentUserDTO;

    private CommentPostDTO commentPostDTO;

    public Long getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public CommentUserDTO getCommentUserDTO() {
        return commentUserDTO;
    }

    public CommentPostDTO getCommentPostDTO() {
        return commentPostDTO;
    }

    public CommentDTO() {
    }

    public CommentDTO(Long commentId, String content, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public CommentDTO(Long commentId, String content, LocalDateTime createdAt, CommentUserDTO commentUserDTO, CommentPostDTO commentPostDTO) {
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
        this.commentUserDTO = commentUserDTO;
        this.commentPostDTO = commentPostDTO;
    }
}

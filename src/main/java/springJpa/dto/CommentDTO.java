package springJpa.dto;

import java.time.LocalDateTime;

public class CommentDTO {

    private Long commentId;
    private String content;
    private LocalDateTime createdAt;

    private UserDTO userDTO;

    private PostDTO postDTO;

    public Long getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public CommentDTO() {
    }

    public CommentDTO(Long commentId, String content, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public CommentDTO(Long commentId, String content, LocalDateTime createdAt, UserDTO userDTO, PostDTO postDTO) {
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
        this.userDTO = userDTO;
        this.postDTO = postDTO;
    }
}

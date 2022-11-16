package springJpa.dto;

import java.time.LocalDateTime;

public class CommentPostDTO {

    private Long postId;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public CommentPostDTO() {
    }

    public CommentPostDTO(Long postId, String title, String content, LocalDateTime createdAt) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
}

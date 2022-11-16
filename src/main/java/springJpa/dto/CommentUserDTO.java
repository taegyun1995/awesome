package springJpa.dto;

import java.time.LocalDateTime;

public class CommentUserDTO {

    private Long userId;
    private String name;
    private LocalDateTime createdAt;

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public CommentUserDTO() {
    }

    public CommentUserDTO(Long userId, String name, LocalDateTime createdAt) {
        this.userId = userId;
        this.name = name;
        this.createdAt = createdAt;
    }
}

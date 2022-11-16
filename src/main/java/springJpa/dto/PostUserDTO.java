package springJpa.dto;

import java.time.LocalDateTime;

public class PostUserDTO {
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

    public PostUserDTO(Long userId, String name, LocalDateTime createdAt) {
        this.userId = userId;
        this.name = name;
        this.createdAt = createdAt;
    }
}

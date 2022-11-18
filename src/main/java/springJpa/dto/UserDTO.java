package springJpa.dto;

import springJpa.domain.User;

import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {

    private Long userId;
    private String name;
    private LocalDateTime createdAt;
    private List<PostDTO> posts;
    private List<CommentDTO> comments;

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public UserDTO() {
    }

    public UserDTO(Long userId, String name, LocalDateTime createdAt) {
        this.userId = userId;
        this.name = name;
        this.createdAt = createdAt;
    }

    public UserDTO(Long userId, String name, LocalDateTime createdAt, List<PostDTO> posts, List<CommentDTO> comments) {
        this.userId = userId;
        this.name = name;
        this.createdAt = createdAt;
        this.posts = posts;
        this.comments = comments;
    }

    public static UserDTO mapper(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getCreatedAt(),
                user.getPosts().stream().map((post ->
                        new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt()))).toList(),
                user.getComments().stream().map((comment ->
                        new CommentDTO(comment.getId(), comment.getContent(), comment.getCreatedAt()))).toList()
        );
    }

}

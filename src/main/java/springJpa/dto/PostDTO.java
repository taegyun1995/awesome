package springJpa.dto;

import springJpa.domain.Post;
import springJpa.domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDTO {

    private Long postId;
    private String title;
    private String content;

    private LocalDateTime createdAt;

    private PostUserDTO postUserDTO;

    private List<CommentDTO> comments = new ArrayList<>();

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

    public PostUserDTO getPostUserDTO() {
        return postUserDTO;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public PostDTO() {
    }

    public PostDTO(Long postId, String title, String content, LocalDateTime createdAt) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public PostDTO(Long postId, String title, String content, LocalDateTime createdAt, PostUserDTO postUserDTO) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.postUserDTO = postUserDTO;
    }

}

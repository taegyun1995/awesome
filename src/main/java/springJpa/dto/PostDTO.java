package springJpa.dto;

import springJpa.domain.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public PostDTO(Long postId, String title, String content, LocalDateTime createdAt, PostUserDTO postUserDTO, List<CommentDTO> comments) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.postUserDTO = postUserDTO;
        this.comments = comments;
    }

    public static PostDTO optionalMapper(Optional<Post> post) {
        PostDTO postDto = new PostDTO(post.get().getId(), post.get().getTitle(), post.get().getContent(), post.get().getCreatedAt(),
                new PostUserDTO(post.get().getUser().getId(), post.get().getUser().getName(), post.get().getCreatedAt()),
                post.get().getComments().stream().map(comment ->
                        new CommentDTO(comment.getId(), comment.getContent(), comment.getCreatedAt())).toList());
        return postDto;
    }

    public static PostDTO mapper(Post post) {
        PostDTO postDto = new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt(),
                new PostUserDTO(post.getUser().getId(), post.getUser().getName(), post.getCreatedAt()),
                post.getComments().stream().map(comment ->
                        new CommentDTO(comment.getId(), comment.getContent(), comment.getCreatedAt())).toList());
        return postDto;
    }

    public static PostDTO mapper2(Post post) {
        PostDTO postDto = new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt(),
                new PostUserDTO(post.getUser().getId(), post.getUser().getName(), post.getCreatedAt()),
                post.getComments().stream().map(comment ->
                        new CommentDTO(comment.getId(), comment.getContent(), comment.getCreatedAt())).toList());
        return postDto;
    }
}

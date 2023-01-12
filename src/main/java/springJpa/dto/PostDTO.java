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

    private UserDTO userDTO;

    private List<CommentDTO> comments = new ArrayList<>();

    private Integer commentSize;

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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public Integer getCommentSize() {
        return commentSize;
    }

    public void setCommentSize(Integer commentSize) {
        this.commentSize = commentSize;
    }

    public void addCommentSize() {
        commentSize = 0;
        this.commentSize++;
    }

    public PostDTO() {
    }

    public PostDTO(Long postId, String title, String content, LocalDateTime createdAt) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public PostDTO(Long postId, String title, String content, LocalDateTime createdAt, UserDTO userDTO, Integer commentSize) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.userDTO = userDTO;
        this.commentSize = commentSize;
    }

    public PostDTO(Long postId, String title, String content, LocalDateTime createdAt, UserDTO userDTO) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.userDTO = userDTO;
    }

    public PostDTO(Long postId, String title, String content, LocalDateTime createdAt, UserDTO userDTO, List<CommentDTO> comments) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.userDTO = userDTO;
        this.comments = comments;
    }

    public static PostDTO optionalMapper(Optional<Post> post) {
        PostDTO postDto = new PostDTO(post.get().getId(), post.get().getTitle(), post.get().getContent(), post.get().getCreatedAt(),
                new UserDTO(post.get().getUser().getId(), post.get().getUser().getName(), post.get().getCreatedAt()),
                post.get().getComments().stream().map(comment ->
                        new CommentDTO(comment.getId(), comment.getContent(), comment.getCreatedAt())).toList());
        return postDto;
    }

    public static PostDTO mapper(Post post) {
        PostDTO postDto = new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt(),
                new UserDTO(post.getUser().getId(), post.getUser().getName(), post.getCreatedAt()),
                post.getComments().stream().map(comment ->
                        new CommentDTO(comment.getId(), comment.getContent(), comment.getCreatedAt())).toList());
        return postDto;
    }

    public static PostDTO mapper2(Post post) {
        PostDTO postDto = new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt(),
                new UserDTO(post.getUser().getId(), post.getUser().getName(), post.getCreatedAt()),
                post.getComments().size());
        return postDto;
    }
}




package springJpa.dto;

public class PostForm {

    Long postId;

    public Long getPostId() {
        return postId;
    }

    String title;

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

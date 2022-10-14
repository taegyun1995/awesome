package springJpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {

    @Id @GeneratedValue
    @Column(name = "postId")
    private Long id;
    @Column(name = "userId")
    private Long userId;
    private String title;
    private String author;

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Post() {
    }

    public Post(Long id, Long userId, String title, String author) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.author = author;
    }
}

package springJpa.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id @GeneratedValue
    @Column(name = "userId")
    private Long id;

    private String name;

//    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private Post post;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User() {
    }

    public User(Long id, String name, Post post, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.post = post;
        this.createdAt = createdAt;
    }
}

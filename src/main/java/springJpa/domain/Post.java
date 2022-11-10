package springJpa.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private Long id;

    private String title;
    private String author;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//    private User user;
//
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "postId")
//    private List<Comment> comments = new ArrayList<>();

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }


    public Post() {
    }

    public Post(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}

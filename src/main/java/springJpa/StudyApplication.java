package springJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import springJpa.domain.Comment;
import springJpa.domain.Post;
import springJpa.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@SpringBootApplication
public class StudyApplication {

//    @PersistenceContext
//    private EntityManager em;
//
//    @Transactional
//    @EventListener(ApplicationReadyEvent.class) // application 준비 https://mr-popo.tistory.com/113
//    public void started() {
//        for (int i = 0; i < 20; i++) {
//
//            LocalDateTime date = LocalDateTime.now();
//
//            User user = new User();
//            user.setName("태균" + i);
//            user.setCreatedAt(date);
//
//            em.persist(user);
//
//            Post post = new Post();
//            post.setAuthor("휴먼" + i);
//            post.setTitle("heHe" + i);
//            post.setUser(user);
//
//
//            for (int j = 0; j < 10; j++) {
//                Comment comment = new Comment();
//                comment.setContent("gg" + j);
//                comment.setCreatedAt(date);
//                post.getComments().add(comment);
//                em.persist(comment);
//                em.persist(post);
//            }
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

}

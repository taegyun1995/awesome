package springJpa.repository;

import org.springframework.stereotype.Repository;
import springJpa.domain.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Post> findAll(Long userId) {
        return em.createQuery("select p from Post p where userId = :userId", Post.class)
                .setParameter("userId", userId)
                .getResultList();
    }


}

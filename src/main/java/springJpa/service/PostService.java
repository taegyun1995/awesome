package springJpa.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springJpa.domain.Post;
import springJpa.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PersistenceContext
    private EntityManager em;

//    select p from Post p join fetch p.user u where p.user.id = : userId", Post.class

    public List<Post> findByIdOrderByIdDesc(Long id, Pageable pageable) {
        return em.createQuery("select p from Post p join fetch p.user join fetch p.comments where p.id = : id ",
                        Post.class)
                .setParameter("id", id)
                .getResultList();

    }
}

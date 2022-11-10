package springJpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springJpa.domain.Post;
import springJpa.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Post create(Post post) {
        Post savePost = postRepository.save(post);
        em.persist(savePost);

        return savePost;
    }

    @Transactional
    public Optional<Post> findOne(Long postId) {
        Optional<Post> findPost = postRepository.findById(postId);

        return findPost;
    }

    @Transactional
    public List<Post> findAll() {
        List<Post> getPosts = postRepository.findAll();

        return getPosts;
    }

    @Transactional
    public void updatePost(Post post) {
        Long postId = post.getId();

        Optional<Post> getPost  = postRepository.findById(postId);
    }



//    @Transactional
//    public List<Post> findByIdOrderByIdDesc(Long id, Pageable pageable) {
//        return em.createQuery("select p from Post p join fetch p.user join fetch p.comments where p.id = : id ", Post.class)
//                .setParameter("id", id)
//                .getResultList();
//    }



}

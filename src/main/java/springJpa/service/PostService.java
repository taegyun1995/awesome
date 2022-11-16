package springJpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springJpa.domain.Post;
import springJpa.domain.User;
import springJpa.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
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
        LocalDateTime date = LocalDateTime.now();

        post.setCreatedAt(date);
        Post savePost = postRepository.save(post);
        em.persist(savePost);

        return savePost;
    }

    @Transactional
    public Optional<Post> findOne(Long postId) {
        Optional<Post> findPost = postRepository.findById(postId);

        return findPost;
    }

//    @Transactional
//    public List<Post> findAll() {
//        List<Post> getPosts = postRepository.findAll();
//
//        return getPosts;
//    }

//    @Transactional
//    public void update(Post post) {
//        Long postId = post.getId();
//        Post findPost  = postRepository.findById(postId).get();
//
//        findPost.setTitle(post.getTitle());
//        findPost.setAuthor(post.getAuthor());
//        postRepository.save(findPost);
//    }

//    @Transactional
//    public void update(PostForm postForm) {
//        Post findPost = postRepository.findById(postForm.getPostId()).get();
//
//        findPost.setTitle(postForm.getTitle());
//        findPost.setAuthor(postForm.getAuthor());
//        postRepository.save(findPost);
//    }

//    @Transactional
//    public List<Post> findByIdOrderByIdDesc(Long id, Pageable pageable) {
//        return em.createQuery("select p from Post p join fetch p.user join fetch p.comments where p.id = : id ", Post.class)
//                .setParameter("id", id)
//                .getResultList();
//    }


}

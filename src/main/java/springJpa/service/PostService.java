package springJpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springJpa.domain.Post;
import springJpa.domain.User;
import springJpa.dto.PostDTO;
import springJpa.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Collection;
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
        LocalDateTime date = LocalDateTime.now();

        post.setCreatedAt(date);
        post.setCommentSize(0);
        Post savePost = postRepository.save(post);

        return savePost;
    }

    @Transactional
    public Optional<Post> findOne(Long postId) {
//        Optional<Post> findPost = postRepository.findById(postId);
//        return findPost;

        // 1안 . 게시글 1개 조회 성능 향상
        Post post = em.createQuery("select p from Post p join fetch p.user join fetch p.comments where p.id = : id ", Post.class)
                .setParameter("id", postId)
                .getSingleResult();

        return Optional.ofNullable(post);

        // 2안
//        return em.createQuery("select p from Post p join fetch p.user join fetch p.comments where p.id = : id ", Post.class)
//                .setParameter("id", postId)
//                .getResultStream().findAny();
    }

    @Transactional
    public List<Post> findAll() {
//        List<Post> getPosts = postRepository.findAll();
//
//        return getPosts;
        // 포스트 전체 조회 성능 향상
        return em.createQuery("select p from Post p join fetch p.user join fetch p.comments", Post.class)
                .getResultList();
    }

//    @Transactional
//    public void update(Post post) {
//        Long postId = post.getId();
//        Post findPost  = postRepository.findById(postId).get();
//
//        findPost.setTitle(post.getTitle());
//        findPost.setAuthor(post.getAuthor());
//        postRepository.save(findPost);
//    }

    @Transactional
    public void update(PostDTO postDTO) {
        Post findPost = postRepository.findById(postDTO.getPostId()).get();

        findPost.setTitle(postDTO.getTitle());
        postRepository.save(findPost);
    }

    @Transactional
    public void updateCommentSize(PostDTO postDTO) {
        Post findPost = postRepository.findById(postDTO.getPostId()).get();

        findPost.addCommentSize();
    }

//    @Transactional
//    public List<Post> findByIdOrderByIdDesc(Long id, Pageable pageable) {
//        return em.createQuery("select p from Post p join fetch p.user join fetch p.comments where p.id = : id ", Post.class)
//                .setParameter("id", id)
//                .getResultList();
//    }


}

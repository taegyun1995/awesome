package springJpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springJpa.domain.Post;
import springJpa.domain.User;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

//    public List<Post> findByUserId(Long userId) {
//        return em.createQuery("select p from Post p join fetch p.user u where p.user.id = : userId", Post.class)
//                .setParameter("userId", userId)
//                .getResultList();

    List<Post> findAllByUserId(Long userId);

    List<Post> findTop50ByUserIdOrderByIdDesc(Long userId);

    Page<Post> findByUserIdOrderByIdDesc(Long userId, Pageable pageable);



}


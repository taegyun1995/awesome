package springJpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springJpa.domain.Comment;
import springJpa.repository.CommentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Service
public class CommentService {

    @PersistenceContext
    private EntityManager em;

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    public Comment create(Comment comment) {
        LocalDateTime date = LocalDateTime.now();
        comment.setCreatedAt(date);
        Comment saveComment = commentRepository.save(comment);
        em.persist(saveComment);

        return saveComment;
    }

}

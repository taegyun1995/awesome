package springJpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springJpa.domain.Post;
import springJpa.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(Long userId) {
        return postRepository.findByUserId(userId);
    }

    public List<Post> findTop3Limit(Long userId) {
        return postRepository.findTop50ByUserIdOrderByIdDesc(userId);
    }

}

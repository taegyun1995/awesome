package springJpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springJpa.domain.Post;
import springJpa.repository.PostRepository;
import springJpa.service.PostService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/posts")
    public Map<String, Object> getPosts(@RequestParam("userId") Long userId) {
        // -> user_id
        // post.user_id 찾아
        // post_list 반환

        Map<String, Object> map = new HashMap<>();
        List<Post> posts = postService.findAll(userId);

        // { post_list: [] }
        map.put("post_list", posts);

        return map;
    }
}

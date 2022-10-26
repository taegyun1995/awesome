package springJpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springJpa.domain.Post;
import springJpa.service.PostService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public Map<String, Object> getPosts(@RequestParam("userId") Long userId) {
        // -> user_id
        // post.user_id 찾아
        // post_list 반환

        Map<String, Object> map = new HashMap<>();
//        List<Post> posts = postService.findAll(userId);
        List<Post> limit50 = postService.findTop3Limit(userId);

        // { post_list: [] }
        map.put("post_list", limit50);

        return map;
    }
}

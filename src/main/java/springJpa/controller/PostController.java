package springJpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springJpa.domain.Post;
import springJpa.repository.PostRepository;
import springJpa.service.PostService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public Map<String, Object> getPostPage(@RequestParam("userId") Long userId, @RequestParam("page") int page,
                                           Pageable pageable) {

        Map<String, Object> map = new HashMap<>();
//        List<Post> posts = postService.findAll(userId);
//        List<Post> postList = postService.findTop3Limit(userId);
        PageRequest pr = PageRequest.of(page-1, 50);
        Page<Post> postList = postRepository.findByUserIdOrderByIdDesc(userId, pr);

        // { post_list: [] }
        map.put("post_list", postList.getContent());
        map.put("pageable", postList);

        return map;
    }
}

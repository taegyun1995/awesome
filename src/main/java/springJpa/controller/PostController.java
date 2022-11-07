package springJpa.controller;

import net.bytebuddy.utility.nullability.AlwaysNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
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
    private PostRepository postRepository;


    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public Map<String, Object> getPostPage(@RequestParam("postId") Long postId,
                                           @RequestParam("page") int page,
                                           Pageable pageable) {

        Map<String, Object> map = new HashMap<>();
//        List<Post> posts = postService.findAll(userId);
//        List<Post> postList = postService.findTop3Limit(userId);
        PageRequest pr = PageRequest.of(page - 1, 5);
//        Page<Post> postList = postRepository.findByUserIdOrderByIdDesc(userId, pr);
        List<Post> postList = postService.findByIdOrderByIdDesc(postId, pr);

        int postSize = postRepository.findAll().size();

        int lastPage = Math.max((int) Math.ceil(postSize / 5), 1);

        // { post_list: [] }
        map.put("post_list", postList);
//        map.put("pageable", postList);
        map.put("last_page", lastPage);

        return map;
    }
}

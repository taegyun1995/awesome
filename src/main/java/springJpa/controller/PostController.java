package springJpa.controller;

import org.springframework.web.bind.annotation.*;
import springJpa.domain.Post;
import springJpa.service.PostService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public Map<String, Object> createPost(@ModelAttribute Post post) {
        Map<String, Object> map = new HashMap<>();
        Post savePost = postService.create(post);

        map.put("post", savePost);

        return map;
    }

    @GetMapping("/get/post")
    public Map<String, Object> getPost(Long postId) {
        Map<String, Object> map = new HashMap<>();
        Optional<Post> post = postService.findOne(postId);

        map.put("post", post);

        return map;
    }

    @GetMapping("/get/postList")
    public Map<String, Object> getPosts() {
        Map<String, Object> map = new HashMap<>();

        List<Post> postList = postService.findAll();
        map.put("postList", postList);

        return map;
    }


//    @GetMapping("/posts")
//    public Map<String, Object> getPostPage(@RequestParam("postId") Long postId,
//                                           @RequestParam("page") int page,
//                                           Pageable pageable) {
//
//        Map<String, Object> map = new HashMap<>();
////        List<Post> posts = postService.findAll(userId);
////        List<Post> postList = postService.findTop3Limit(userId);
//        PageRequest pr = PageRequest.of(page - 1, 5);
////        Page<Post> postList = postRepository.findByUserIdOrderByIdDesc(userId, pr);
//        List<Post> postList = postService.findByIdOrderByIdDesc(postId, pr);
//
//        int postSize = postRepository.findAll().size();
//
//        int lastPage = Math.max((int) Math.ceil(postSize / 5), 1);
//
//        // { post_list: [] }
//        map.put("post_list", postList);
////        map.put("pageable", postList);
//        map.put("last_page", lastPage);
//
//        return map;
//    }
}

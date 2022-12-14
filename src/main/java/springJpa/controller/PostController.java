package springJpa.controller;

import org.springframework.web.bind.annotation.*;
import springJpa.domain.Post;
import springJpa.dto.PostDTO;
import springJpa.dto.UserDTO;
import springJpa.service.PostService;

import java.awt.print.Pageable;
import java.util.*;

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
        PostDTO postDto = new PostDTO(savePost.getId(), savePost.getTitle(), savePost.getContent(), savePost.getCreatedAt(),
                new UserDTO(savePost.getUser().getId(), savePost.getUser().getName(), savePost.getUser().getCreatedAt()));

        map.put("post", postDto);

        return map;
    }

    @GetMapping("/post/{postId}")
    public Map<String, Object> getPost(@PathVariable("postId") Long postId) {
        Map<String, Object> map = new HashMap<>();

        Optional<Post> post = postService.findOne(postId);
        PostDTO postDto = PostDTO.optionalMapper(post);
        map.put("post", postDto);

        return map;
    }

    @GetMapping("/posts/V1")
    public Map<String, Object> getPostsV1() {
        Map<String, Object> map = new HashMap<>();

        List<Post> postList = postService.findAll();
        List<PostDTO> postDTOs = new ArrayList<>();

        for (Post post : postList) {
            PostDTO postDTO = PostDTO.mapper(post);
            postDTOs.add(postDTO);
        }

        map.put("postList", postDTOs);

        return map;
    }

    @GetMapping("/posts/V2")
    public Map<String, Object> getPostsV2() {
        Map<String, Object> map = new HashMap<>();

        List<Post> postList = postService.findAll();
        List<PostDTO> postDTOs = new ArrayList<>();

        for (Post post : postList) {
            PostDTO postDTO = PostDTO.mapper2(post);
            postDTOs.add(postDTO);
        }

        map.put("postList", postDTOs);

        return map;
    }

//    @PutMapping("/post/{postId}")
//    public Map<String, Object> updatePost(@ModelAttribute PostForm postForm) {
//        Map<String, Object> map = new HashMap<>();
//
//        postService.update(postForm);
//        map.put("postId", postForm.getPostId());
//
//        return map;
//    }


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

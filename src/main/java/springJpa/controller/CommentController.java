package springJpa.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springJpa.domain.Comment;
import springJpa.domain.Post;
import springJpa.dto.CommentDTO;
import springJpa.dto.PostDTO;
import springJpa.dto.UserDTO;
import springJpa.service.CommentService;
import springJpa.service.PostService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping("/comment")
    public Map<String, Object> create(@ModelAttribute Comment comment) {
        Map<String, Object> map = new HashMap<>();
        Comment saveComment = commentService.create(comment);
        CommentDTO commentDTO = new CommentDTO(saveComment.getId(), saveComment.getContent(), saveComment.getCreatedAt(),
                new UserDTO(saveComment.getUser().getId(), saveComment.getUser().getName(), saveComment.getUser().getCreatedAt()),
                new PostDTO(saveComment.getPost().getId(), saveComment.getPost().getTitle(), saveComment.getPost().getContent(), saveComment.getPost().getCreatedAt(),
                        new UserDTO(saveComment.getPost().getUser().getId(), saveComment.getPost().getUser().getName(), saveComment.getPost().getUser().getCreatedAt())));

//        postService.updateCommentSize();

        map.put("comment", commentDTO);

        return map;
    }

}
package springJpa.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springJpa.domain.Comment;
import springJpa.dto.CommentDTO;
import springJpa.dto.CommentPostDTO;
import springJpa.dto.CommentUserDTO;
import springJpa.service.CommentService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public Map<String, Object> create(@ModelAttribute Comment comment) {
        Map<String, Object> map = new HashMap<>();
        Comment saveComment = commentService.create(comment);
        CommentDTO commentDTO = new CommentDTO(saveComment.getId(), saveComment.getContent(), saveComment.getCreatedAt(),
                new CommentUserDTO(saveComment.getUser().getId(), saveComment.getUser().getName(), saveComment.getUser().getCreatedAt()),
                new CommentPostDTO(saveComment.getPost().getId(), saveComment.getPost().getTitle(), saveComment.getPost().getContent(), saveComment.getPost().getCreatedAt()));

        map.put("comment", commentDTO);

        return map;
    }

}

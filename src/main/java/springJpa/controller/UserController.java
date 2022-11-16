package springJpa.controller;

import org.springframework.web.bind.annotation.*;
import springJpa.domain.User;
import springJpa.dto.UserDTO;
import springJpa.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public Map<String, Object> save(@ModelAttribute User user) {
        Map<String, Object> map = new HashMap<>();
        User saveUser = userService.save(user);
        map.put("user", saveUser);

        return map;
    }

//    @GetMapping("/user/{userId}")
//    public Map<String, Object> find(@PathVariable("userId") Long userId) {
//        Map<String, Object> map = new HashMap<>();
//
//        User user = userService.findById(userId);
//
//        ArrayList<PostDTO> postDTOList = new ArrayList<>();
//
//        for (Post post : user.getPosts()) {
//            postDTOList.add(new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt()));
//        }
//        UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getCreatedAt(), new UserPostDTO(postDTOList));
//
//        map.put("user", userDTO);
//
//        return map;
//    }

    @GetMapping("/user/{userId}")
    public Map<String, Object> find(@PathVariable("userId") Long userId) {
        Map<String, Object> map = new HashMap<>();

        User user = userService.findById(userId);
        UserDTO userDTO = UserDTO.mapper(user);

        map.put("user", userDTO);

        return map;
    }

//    @GetMapping("/users")
//    public Map<String, Object> findAll() {
//        Map<String, Object> map = new HashMap<>();
//        List<User> users = userService.findAll();
//
//        map.put("users", users);
//
//        return map;
//    }
}

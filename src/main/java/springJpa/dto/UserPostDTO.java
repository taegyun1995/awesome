package springJpa.dto;

import java.util.List;

public class UserPostDTO {

    private List<PostDTO> posts;

    public List<PostDTO> getPosts() {
        return posts;
    }

    public UserPostDTO(List<PostDTO> posts) {
        this.posts = posts;
    }
}


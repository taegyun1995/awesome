package springJpa.dto;

public class PostResponse {

    private String title;

    private String author;

    private PostUserResponse postUserResponse;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public PostUserResponse getPostUserResponse() {
        return postUserResponse;
    }

    public PostResponse(String title, String author, PostUserResponse postUserResponse) {
        this.title = title;
        this.author = author;
        this.postUserResponse = postUserResponse;
    }
}

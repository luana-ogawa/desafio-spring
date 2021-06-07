package br.com.digitalhouse.desafiospring.desafiospring.dto;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;

import java.util.List;

public class PostListDTO {

    private Integer userId;
    private List<Newpost> posts;

    public PostListDTO(Integer userId, List<Newpost> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Newpost> getPosts() {
        return posts;
    }

    public void setPosts(List<Newpost> posts) {
        this.posts = posts;
    }
}

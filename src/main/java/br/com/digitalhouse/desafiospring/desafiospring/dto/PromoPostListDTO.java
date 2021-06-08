package br.com.digitalhouse.desafiospring.desafiospring.dto;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.domain.NewpostPromo;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;

import java.util.List;
import java.util.stream.Collectors;

public class PromoPostListDTO {

    private Integer userId;
    private String userName;
    private List<Newpost> posts;

    public PromoPostListDTO(Seller seller) {
        this.userId = seller.getUserId();
        this.userName = seller.getUserName();
        this.posts = seller.getNewposts().stream()
                .filter(newpost -> newpost instanceof NewpostPromo)
                .filter(newpost -> ((NewpostPromo) newpost).isHasPromo())
                .collect(Collectors.toList());
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Newpost> getPosts() {
        return posts;
    }

    public void setPosts(List<Newpost> posts) {
        this.posts = posts;
    }
}

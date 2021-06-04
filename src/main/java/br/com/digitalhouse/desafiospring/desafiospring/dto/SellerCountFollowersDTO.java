package br.com.digitalhouse.desafiospring.desafiospring.dto;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;

import java.io.Serializable;

public class SellerCountFollowersDTO implements Serializable {

    private Integer userId;
    private String userName;
    private Integer followers_count;

    public SellerCountFollowersDTO() {
    }

    public SellerCountFollowersDTO(Seller seller) {
        userId = seller.getUserId();
        userName = seller.getUserName();
        followers_count = seller.getFollowers_count();
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

    public Integer getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(Integer followers_count) {
        this.followers_count = followers_count;
    }
}

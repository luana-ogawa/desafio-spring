package br.com.digitalhouse.desafiospring.desafiospring.dto;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Buyer;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SellerDTO implements Serializable {

    private Integer userId;
    private String userName;
    private List<Buyer> followers = new ArrayList<>();

    public SellerDTO() {
    }

    public SellerDTO(Seller seller) {
        userId = seller.getUserId();
        userName = seller.getUserName();
        followers = seller.getFollowers();
    }

    public SellerDTO(Seller seller, String order) {
        userId = seller.getUserId();
        userName = seller.getUserName();
        followers = seller.getFollowers();

        if(order.equals("name_asc")){
            Collections.sort(followers);
        } else if(order.equals("name_desc")){
            Collections.sort(followers, Collections.reverseOrder());
        }
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

    public List<Buyer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Buyer> followers) {
        this.followers = followers;
    }
}

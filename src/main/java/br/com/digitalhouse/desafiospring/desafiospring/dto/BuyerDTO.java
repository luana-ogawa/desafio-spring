package br.com.digitalhouse.desafiospring.desafiospring.dto;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Buyer;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BuyerDTO implements Serializable {

    private Integer userId;
    private String userName;
    private List<Seller> followed = new ArrayList<>();

    public BuyerDTO(){
    }

    public BuyerDTO(Buyer buyer) {
        this.userId = buyer.getUserId();
        this.userName = buyer.getUserName();
        this.followed = buyer.getFollowed();
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

    public List<Seller> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Seller> followed) {
        this.followed = followed;
    }
}

package br.com.digitalhouse.desafiospring.desafiospring.dto;

import br.com.digitalhouse.desafiospring.desafiospring.domain.NewpostPromo;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;

public class CountPromoDTO {

    private Integer userId;
    private String userName;
    private Long promoproducts_count;

    public CountPromoDTO(Seller seller) {
        this.userId = seller.getUserId();
        this.userName = seller.getUserName();
        this.promoproducts_count = seller.getNewposts().stream()
                .filter(newpost -> newpost instanceof NewpostPromo)
                .filter(newpost -> ((NewpostPromo) newpost).isHasPromo())
                .count();
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

    public Long getPromoproducts_count() {
        return promoproducts_count;
    }

    public void setPromoproducts_count(Long promoproducts_count) {
        this.promoproducts_count = promoproducts_count;
    }
}

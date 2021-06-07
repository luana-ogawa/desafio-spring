package br.com.digitalhouse.desafiospring.desafiospring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Buyer implements Serializable, Comparable<Buyer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "BUYER_SELLER",
            joinColumns = @JoinColumn(name = "buyer_id"),
            inverseJoinColumns = @JoinColumn(name = "seller_id")
    )
    private List<Seller> followed = new ArrayList<>();

    public Buyer(){
    }

    public Buyer(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(userId, buyer.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public int compareTo(Buyer o) {
        return getUserName().compareTo(o.getUserName());
    }

}

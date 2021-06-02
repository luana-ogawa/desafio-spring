package br.com.digitalhouse.desafiospring.desafiospring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Seller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;

    @JsonManagedReference
    @ManyToMany(mappedBy = "followed")
    private List<Buyer> followers = new ArrayList<>();

    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "seller")
    private List<Newpost> newposts = new ArrayList<>();

    public Seller() {
    }

    public Seller(Integer userId, String userName) {
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

    public List<Buyer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Buyer> followers) {
        this.followers = followers;
    }

    public List<Newpost> getNewposts() {
        return newposts;
    }

    public void setNewposts(List<Newpost> newposts) {
        this.newposts = newposts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller vendedor = (Seller) o;
        return Objects.equals(userId, vendedor.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}

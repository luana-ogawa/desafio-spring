package br.com.digitalhouse.desafiospring.desafiospring.dtos;

import java.util.List;

public class SellerDTO {

    private int userId;
    private String userName;
    private List<UserDTO> followers;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }
}

package br.com.digitalhouse.desafiospring.desafiospring.dtos;

import java.util.List;

public class UserDTO {

    private int userId;
    private String userName;
    private List<SellerDTO> followed;

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

    public List<SellerDTO> getFollowed() {
        return followed;
    }

    public void setFollowed(List<SellerDTO> followed) {
        this.followed = followed;
    }
}

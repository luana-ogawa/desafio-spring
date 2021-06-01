package br.com.digitalhouse.desafiospring.desafiospring.service;

//import br.com.digitalhouse.desafiospring.desafiospring.dtos.SellerDTO;
import br.com.digitalhouse.desafiospring.desafiospring.dtos.UserDTO;

public interface SocialMeli {

    public UserDTO follow(Integer userID, Integer userIDToFollow);
    public UserDTO getUserName(Integer userId);

}

package br.com.digitalhouse.desafiospring.desafiospring.service;

import br.com.digitalhouse.desafiospring.desafiospring.dtos.SellerDTO;
import br.com.digitalhouse.desafiospring.desafiospring.dtos.UserDTO;

public interface Follow {

    public void follow(UserDTO user, SellerDTO userToFollow);

}

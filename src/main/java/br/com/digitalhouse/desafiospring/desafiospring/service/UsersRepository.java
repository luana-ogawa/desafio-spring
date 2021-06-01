package br.com.digitalhouse.desafiospring.desafiospring.service;

import br.com.digitalhouse.desafiospring.desafiospring.dtos.UserDTO;

import java.util.List;

public interface UsersRepository {

    UserDTO findUserNameByUserId(Integer userId);
    public void writeUsersDatabase(UserDTO userDTO);

}

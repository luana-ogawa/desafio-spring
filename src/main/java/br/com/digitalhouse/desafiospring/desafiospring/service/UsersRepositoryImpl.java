package br.com.digitalhouse.desafiospring.desafiospring.service;

import br.com.digitalhouse.desafiospring.desafiospring.dtos.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class UsersRepositoryImpl implements UsersRepository{

    @Override
    public UserDTO findUserNameByUserId(Integer userId) {

        List<UserDTO> userDTOList = null;
        userDTOList = loadUsersDataBase();
        UserDTO result = null;
        if(userDTOList != null) {
            result = userDTOList.stream()
                    .filter(element -> element.getUserId().equals(userId))
                    .findFirst().orElse(null);
        }
        return result;
    }

    @Override
    public void writeUsersDatabase(UserDTO userDTO){

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, userDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<UserDTO> loadUsersDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<UserDTO>> typeRef = new TypeReference<>() {};
        List<UserDTO> userDTOList = null;
        try {
            userDTOList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDTOList;

    }

}

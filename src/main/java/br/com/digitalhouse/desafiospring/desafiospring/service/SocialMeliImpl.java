package br.com.digitalhouse.desafiospring.desafiospring.service;

import br.com.digitalhouse.desafiospring.desafiospring.dtos.SellerDTO;
import br.com.digitalhouse.desafiospring.desafiospring.dtos.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class SocialMeliImpl implements SocialMeli {

    private final UsersRepository usersRepository;
    private final SellersRepository sellersRepository;

    public SocialMeliImpl(UsersRepository usersRepository, SellersRepository sellersRepository) {
        this.usersRepository = usersRepository;
        this.sellersRepository = sellersRepository;
    }

    @Override
    public UserDTO follow(Integer userID, Integer userIDToFollow) {
        UserDTO user = usersRepository.findUserNameByUserId(userID);
        SellerDTO userToFollow = sellersRepository.findSellerNameBySellerId(userIDToFollow);
        user.getFollowed().add(userToFollow);
        usersRepository.writeUsersDatabase(user);
        return user;
    }

    @Override
    public UserDTO getUserName(Integer userId) {
        UserDTO responseDTO = usersRepository.findUserNameByUserId(userId);
        return responseDTO;
    }
}

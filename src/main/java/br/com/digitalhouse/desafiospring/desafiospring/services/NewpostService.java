package br.com.digitalhouse.desafiospring.desafiospring.services;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.NewpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewpostService {

    @Autowired
    private NewpostRepository newpostRepository;

    public Newpost insert(Newpost newpost) {
        newpost.setId_post(null);
        return newpostRepository.save(newpost);
    }

}

package br.com.digitalhouse.desafiospring.desafiospring.services;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Product;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.NewpostRepository;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.DataIntegrityException;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewpostService {

    @Autowired
    private NewpostRepository newpostRepository;

    public Newpost insert(Newpost newpost) {
        newpost.setId_post(null);
        return newpostRepository.save(newpost);
    }

    public Newpost findNewpost(Integer id_post) {
        Optional<Newpost> newpost = newpostRepository.findById(id_post);
        return newpost.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id_post));
    }

    public void delete(Integer id_post) {
        findNewpost(id_post);
        try {
            newpostRepository.deleteById(id_post);
        } catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um post que possui produtos");
        }

    }

}

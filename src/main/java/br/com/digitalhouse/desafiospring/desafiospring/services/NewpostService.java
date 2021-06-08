package br.com.digitalhouse.desafiospring.desafiospring.services;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.domain.NewpostPromo;
import br.com.digitalhouse.desafiospring.desafiospring.dto.NewpostDTO;
import br.com.digitalhouse.desafiospring.desafiospring.dto.NewpostPromoDTO;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.NewpostRepository;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.SellerRepository;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.DataIntegrityException;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewpostService {

    @Autowired
    private NewpostRepository newpostRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SellerService sellerService;

    public Newpost insert(NewpostDTO newpostDTO) {
        Newpost newpost = new Newpost(newpostDTO);
        newpost.setId_post(null);

        if(!sellerService.userExists(newpost.getSeller().getUserId())) {
            throw new ObjectNotFoundException("Usuário não existe");
        }
        return newpostRepository.save(newpost);
    }

    public Newpost insertPromo(NewpostPromoDTO newpostPromoDTO) {
        Newpost newpost = new NewpostPromo(newpostPromoDTO);
        newpost.setId_post(null);

        if(!sellerService.userExists(newpost.getSeller().getUserId())) {
            throw new ObjectNotFoundException("Usuário não existe");
        }
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

    public Page<Newpost> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return newpostRepository.findAll(pageRequest);
    }

}

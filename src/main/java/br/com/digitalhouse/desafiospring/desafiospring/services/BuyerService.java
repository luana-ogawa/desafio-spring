package br.com.digitalhouse.desafiospring.desafiospring.services;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Buyer;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.BuyerRepository;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.DataIntegrityException;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public Buyer findBuyer(Integer userId) {
        Optional<Buyer> buyer = buyerRepository.findById(userId);
        return buyer.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + userId));
    }

    public Buyer addFollowed(Buyer buyer, Seller seller) {
//        if(buyer.getFollowed().stream().filter( s -> s.getUserId().equals(seller.getUserId())).findAny().isPresent()) {
//            throw(() -> new DataIntegrityException("Vendedor ja adicionado"));
//        }
        buyer.getFollowed().add(seller);
        return buyerRepository.save(buyer);
    }

    public Buyer removeFollowed(Buyer buyer, Seller seller) {
        buyer.getFollowed().remove(seller);
        return buyerRepository.save(buyer);
    }

    public Page<Buyer> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return buyerRepository.findAll(pageRequest);
    }

}

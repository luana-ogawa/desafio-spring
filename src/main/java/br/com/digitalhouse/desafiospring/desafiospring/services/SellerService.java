package br.com.digitalhouse.desafiospring.desafiospring.services;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Buyer;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.SellerRepository;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller findSeller(Integer userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        return seller.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + userId));
    }

    public Boolean userExists(Integer userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        return seller.isPresent();
    }

}

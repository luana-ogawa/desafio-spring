package br.com.digitalhouse.desafiospring.desafiospring.controller;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/social-meli")
public class SocialMeliController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/users/{UserID}/followers/list", method = RequestMethod.GET)
    public ResponseEntity<?> followersList(@PathVariable Integer UserID) {
        Seller seller = sellerService.findSeller(UserID);
        return ResponseEntity.ok().body(seller);
    }

}

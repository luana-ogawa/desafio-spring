package br.com.digitalhouse.desafiospring.desafiospring.controller;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.services.NewpostService;
import br.com.digitalhouse.desafiospring.desafiospring.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/social-meli")
public class SocialMeliController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private NewpostService newpostService;

    @RequestMapping(value = "/users/{UserID}/followers/list", method = RequestMethod.GET)
    public ResponseEntity<?> followersList(@PathVariable Integer UserID) {
        Seller seller = sellerService.findSeller(UserID);
        return ResponseEntity.ok().body(seller);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Void> insert(@RequestBody Newpost newpost) {
//        newpost = newpostService.insert(newpost);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(newpost.getId_post()).toUri();
//        return ResponseEntity.created(uri).build();
//    }

    @RequestMapping(method = RequestMethod.POST)
    public void insert(@RequestBody Newpost newpost) {
        newpostService.insert(newpost);
    }

}

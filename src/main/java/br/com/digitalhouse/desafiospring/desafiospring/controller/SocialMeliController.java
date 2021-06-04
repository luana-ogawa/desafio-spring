package br.com.digitalhouse.desafiospring.desafiospring.controller;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Product;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.services.ProductService;
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
    private ProductService productService;

    @RequestMapping(value = "/users/{UserID}/followers/list", method = RequestMethod.GET)
    public ResponseEntity<?> followersList(@PathVariable Integer UserID) {
        Seller seller = sellerService.findSeller(UserID);
        return ResponseEntity.ok().body(seller);
    }

    @RequestMapping(value = "/product/{ProductID}", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable Integer ProductID) {
        Product product = productService.findProduct(ProductID);
        return ResponseEntity.ok().body(product);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Product product) {
        product = productService.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(product.getProduct_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

}

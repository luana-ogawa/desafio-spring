package br.com.digitalhouse.desafiospring.desafiospring.controller;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Product;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.services.NewpostService;
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
    @Autowired
    private NewpostService newpostService;

    @RequestMapping(value = "/users/{userID}/followers/list", method = RequestMethod.GET)
    public ResponseEntity<Seller> followersList(@PathVariable Integer userID) {
        Seller seller = sellerService.findSeller(userID);
        return ResponseEntity.ok().body(seller);
    }

    //Product
    @RequestMapping(value = "/product/{productID}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable Integer productID) {
        Product product = productService.findProduct(productID);
        return ResponseEntity.ok().body(product);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Void> insertProduct(@RequestBody Product product) {
        product = productService.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(product.getProduct_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/product/{productID}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productID) {
        productService.delete(productID);
        return ResponseEntity.noContent().build();
    }

    //Newpost
    @RequestMapping(value = "/newpost/{post_id}", method = RequestMethod.GET)
    public ResponseEntity<Newpost> getNewpost(@PathVariable Integer post_id) {
        Newpost newpost = newpostService.findNewpost(post_id);
        return ResponseEntity.ok().body(newpost);
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public ResponseEntity<Void> insertPost(@RequestBody Newpost newpost) {
        newpost = newpostService.insert(newpost);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newpost.getId_post()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/newpost/{post_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePost(@PathVariable Integer post_id) {
        newpostService.delete(post_id);
        return ResponseEntity.noContent().build();
    }

}

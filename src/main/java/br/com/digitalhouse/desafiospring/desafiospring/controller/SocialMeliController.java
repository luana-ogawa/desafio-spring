package br.com.digitalhouse.desafiospring.desafiospring.controller;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Buyer;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Product;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.dto.BuyerDTO;
import br.com.digitalhouse.desafiospring.desafiospring.dto.SellerCountFollowersDTO;
import br.com.digitalhouse.desafiospring.desafiospring.dto.SellerDTO;
import br.com.digitalhouse.desafiospring.desafiospring.services.BuyerService;
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
    private BuyerService buyerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private NewpostService newpostService;

    //Followers
    @RequestMapping(value = "/users/{userID}/followers/list", method = RequestMethod.GET)
    public ResponseEntity<SellerDTO> followersList(@PathVariable Integer userID) {
        Seller seller = sellerService.findSeller(userID);
        SellerDTO sellerDTO = new SellerDTO(seller);
        return ResponseEntity.ok().body(sellerDTO);
    }

    @RequestMapping(value = "/users/{userID}/followers/count", method = RequestMethod.GET)
    public ResponseEntity<SellerCountFollowersDTO> followersCount(@PathVariable Integer userID) {
        Seller seller = sellerService.findSeller(userID);
        SellerCountFollowersDTO sellerCountFollowersDTO = new SellerCountFollowersDTO(seller);
        return ResponseEntity.ok().body(sellerCountFollowersDTO);
    }

    //Followed
    @RequestMapping(value = "/users/{userID}/followed/list", method = RequestMethod.GET)
    public ResponseEntity<BuyerDTO> followedList(@PathVariable Integer userID) {
        Buyer buyer = buyerService.findBuyer(userID);
        BuyerDTO buyerDTO = new BuyerDTO(buyer);
        return ResponseEntity.ok().body(buyerDTO);
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
    @RequestMapping(value = "/products/newpost/{post_id}", method = RequestMethod.GET)
    public ResponseEntity<Newpost> getNewpost(@PathVariable Integer post_id) {
        Newpost newpost = newpostService.findNewpost(post_id);
        return ResponseEntity.ok().body(newpost);
    }

    @RequestMapping(value = "/products/newpost", method = RequestMethod.POST)
    public ResponseEntity<Void> insertPost(@RequestBody Newpost newpost) {
        newpost = newpostService.insert(newpost);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newpost.getId_post()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/products/newpost/{post_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePost(@PathVariable Integer post_id) {
        newpostService.delete(post_id);
        return ResponseEntity.noContent().build();
    }

}

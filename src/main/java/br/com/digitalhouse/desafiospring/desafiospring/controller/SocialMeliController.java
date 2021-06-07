package br.com.digitalhouse.desafiospring.desafiospring.controller;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Buyer;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Product;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.dto.*;
import br.com.digitalhouse.desafiospring.desafiospring.services.BuyerService;
import br.com.digitalhouse.desafiospring.desafiospring.services.NewpostService;
import br.com.digitalhouse.desafiospring.desafiospring.services.ProductService;
import br.com.digitalhouse.desafiospring.desafiospring.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    //Follow
    @RequestMapping(value = "/users/{userId}/follow/{userIdToFollow}", method = RequestMethod.POST)
    public ResponseEntity<Void> followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        Buyer buyer = buyerService.findBuyer(userId);
        Seller seller = sellerService.findSeller(userIdToFollow);
        buyer = buyerService.addFollowed(buyer, seller);
        return ResponseEntity.ok().build();
    }

    //Unfollow
    @RequestMapping(value = "/users/{userId}/unfollow/{userIdToUnfollow}", method = RequestMethod.POST)
    public ResponseEntity<Void> unfollowSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        Buyer buyer = buyerService.findBuyer(userId);
        Seller seller = sellerService.findSeller(userIdToUnfollow);
        buyer = buyerService.removeFollowed(buyer, seller);
        return ResponseEntity.ok().build();
    }

    //Followers
    @RequestMapping(value = "/users/{userID}/followers/list", method = RequestMethod.GET)
    public ResponseEntity<SellerDTO> followersList(@PathVariable Integer userID, @RequestParam(value = "order", required = false) String order) {
        Seller seller = sellerService.findSeller(userID);
        SellerDTO sellerDTO;
        if(order == null){
            sellerDTO = new SellerDTO(seller);
        } else {
            sellerDTO = new SellerDTO(seller, order);
        }
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
    public ResponseEntity<BuyerDTO> followedList(@PathVariable Integer userID, @RequestParam(value = "order", required = false) String order) {
        Buyer buyer = buyerService.findBuyer(userID);
        BuyerDTO buyerDTO;
        if(order == null) {
            buyerDTO = new BuyerDTO(buyer);
        } else {
            buyerDTO = new BuyerDTO(buyer, order);
        }

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
    public ResponseEntity<Newpost> insertPost(@RequestBody NewpostDTO newpostDTO) {
        Newpost newpost = new Newpost(newpostDTO);
        Newpost response = newpostService.insert(newpost);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/products/newpost", method = RequestMethod.POST)
//    public ResponseEntity<Void> insertPost(@RequestBody Newpost newpost) {
//        newpost = newpostService.insert(newpost);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(newpost.getId_post()).toUri();
//        return ResponseEntity.created(uri).build();
//    }

    @RequestMapping(value = "/products/newpost/{post_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePost(@PathVariable Integer post_id) {
        newpostService.delete(post_id);
        return ResponseEntity.noContent().build();
    }

    //Lista de publicacoes do vendedores que o comprador segue
    @RequestMapping(value = "/products/followed/{userId}/list", method = RequestMethod.GET)
    public ResponseEntity<PostListDTO> postList(@PathVariable Integer userId, @RequestParam(value = "order", required = false) String order) {
        PostListDTO postListDTO;
        if(order == null) {
            postListDTO = buyerService.postList(userId, "date_desc");
        } else {
            postListDTO = buyerService.postList(userId, order);
        }
        return ResponseEntity.ok().body(postListDTO);
    }

}

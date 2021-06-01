package br.com.digitalhouse.desafiospring.desafiospring.controller;

import br.com.digitalhouse.desafiospring.desafiospring.dtos.UserDTO;
import br.com.digitalhouse.desafiospring.desafiospring.service.SocialMeli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/social-meli")
public class SocialMeliController {

    @Autowired
    SocialMeli socialMeli;

    @PostMapping(path = "/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserDTO> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return ResponseEntity.ok(socialMeli.follow(userId, userIdToFollow));
    }

    @GetMapping(path = "/users/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(socialMeli.getUserName(userId));
    }

}

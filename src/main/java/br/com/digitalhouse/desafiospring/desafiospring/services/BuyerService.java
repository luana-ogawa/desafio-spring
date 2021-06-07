package br.com.digitalhouse.desafiospring.desafiospring.services;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Buyer;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.dto.PostListDTO;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.BuyerRepository;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.DataIntegrityException;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

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
        if(buyer.getFollowed().stream().filter( s -> s.getUserId().equals(seller.getUserId())).findAny().isPresent()) {
            throw new DataIntegrityException("Vendedor ja adicionado");
        }
        buyer.getFollowed().add(seller);
        return buyerRepository.save(buyer);
    }

    public Buyer removeFollowed(Buyer buyer, Seller seller) {
        if(buyer.getFollowed().stream().filter( s -> s.getUserId().equals(seller.getUserId())).findAny().isEmpty()) {
            throw new DataIntegrityException("Comprador " + buyer.getUserId() + " não segue vendedor " + seller.getUserId());
        }
        buyer.getFollowed().remove(seller);
        return buyerRepository.save(buyer);
    }

//    public PostListDTO postList(Integer buyerID) {
//        Buyer buyer = findBuyer(buyerID);
//        List<Seller> sellerList = buyer.getFollowed();
//        List<Newpost> newpostList = sellerList.stream()
//                .map(seller -> seller.getNewposts())
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());
//        PostListDTO postListDTO = new PostListDTO(buyerID, newpostList);
//        return postListDTO;
//    }

//    new Date()
//    new Date(System.currentTimeMillis())
//    Date.from(Instant.now())
    public PostListDTO postList(Integer buyerID) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date currentDate = Date.from(Instant.now());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, -15);
        currentDate = calendar.getTime();

        Buyer buyer = findBuyer(buyerID);
        List<Seller> sellerList = buyer.getFollowed();
        List<Newpost> newpostList = sellerList.stream()
                .map(seller -> seller.getNewposts())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        Date finalCurrentDate = currentDate;
        List<Newpost> newpostList1 = newpostList.stream()
                .filter(newpost -> newpost.getDate().after(finalCurrentDate))
                .collect(Collectors.toList());

        PostListDTO postListDTO = new PostListDTO(buyerID, newpostList1);
        return postListDTO;
    }

//    public PostListDTO postList(Integer buyerID) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Period p = Period.between(LocalDate.now(), LocalDate.now().minusDays(14));
//        Buyer buyer = findBuyer(buyerID);
//        List<Seller> sellerList = buyer.getFollowed();
//        List<Newpost> newpostList = sellerList.stream()
//                .map(seller -> seller.getNewposts())
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());
//        List<Newpost> newpostList1 = newpostList.stream()
//                .filter(newpost -> newpost.getDate().after(date)
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList());
//        PostListDTO postListDTO = new PostListDTO(buyerID, newpostList);
//        return postListDTO;
//    }

}

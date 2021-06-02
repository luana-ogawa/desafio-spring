package br.com.digitalhouse.desafiospring.desafiospring;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Buyer;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.BuyerRepository;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DesafioSpringApplication implements CommandLineRunner {

	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private BuyerRepository buyerRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Seller seller1 = new Seller(null, "Vendedor1");
		Seller seller2 = new Seller(null, "Vendedor2");
		Seller seller3 = new Seller(null, "Vendedor3");

		Buyer buyer1 = new Buyer(null, "Usuario1");
		Buyer buyer2 = new Buyer(null, "Usuario2");
		Buyer buyer3 = new Buyer(null, "Usuario3");

		seller1.getFollowers().addAll(Arrays.asList(buyer1, buyer2));
		seller2.getFollowers().addAll(Arrays.asList(buyer1, buyer2));
		seller3.getFollowers().addAll(Arrays.asList(buyer3));

		buyer1.getFollowed().addAll(Arrays.asList(seller1,seller2));
		buyer2.getFollowed().addAll(Arrays.asList(seller2));
		buyer3.getFollowed().addAll(Arrays.asList(seller1, seller3));

		sellerRepository.saveAll(Arrays.asList(seller1, seller2, seller3));
		buyerRepository.saveAll(Arrays.asList(buyer1, buyer2, buyer3));

	}
}

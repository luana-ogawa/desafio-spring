package br.com.digitalhouse.desafiospring.desafiospring;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
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

	public static void main(String[] args) {
		SpringApplication.run(DesafioSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Seller seller1 = new Seller(null, "Vendedor1");
		Seller seller2 = new Seller(null, "Vendedor2");
		Seller seller3 = new Seller(null, "Vendedor3");

		sellerRepository.saveAll(Arrays.asList(seller1, seller2, seller3));

	}
}

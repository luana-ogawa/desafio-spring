package br.com.digitalhouse.desafiospring.desafiospring;

import br.com.digitalhouse.desafiospring.desafiospring.domain.*;
import br.com.digitalhouse.desafiospring.desafiospring.domain.enums.Category;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.BuyerRepository;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.NewpostRepository;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.ProductRepository;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class DesafioSpringApplication implements CommandLineRunner {

	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private BuyerRepository buyerRepository;
	@Autowired
	private NewpostRepository newpostRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Seller seller1 = new Seller(null, "Vendedor Katia");
		Seller seller2 = new Seller(null, "Vendedor Alessandra");
		Seller seller3 = new Seller(null, "Vendedor Rodrigo");

		Buyer buyer1 = new Buyer(null, "Comprador Sandra");
		Buyer buyer2 = new Buyer(null, "Comprador Vitoria");
		Buyer buyer3 = new Buyer(null, "Comprador Armando");

		Product product1 = new Product(null, "Cadeira Gamer", "Gamer", "Razer", "Red & Black", "Special Edition");
		Product product2 = new Product(null, "Headset RGB", "Gamer", "Razer", "Green with RGB", "Sem bateria");
		Product product3 = new Product(null, "Mouse Optico", "Gamer", "Razer", "Black", "Sem bateria");
		Product product4 = new Product(null, "Teclado Mecanico", "Gamer", "Razer", "Colourful", "USB");
		Product product5 = new Product(null, "Cadeira Escritorio", "Escritorio", "Comfort", "White", "Leather");

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Newpost newpost1 = new Newpost(null, sdf.parse("03-06-2021"), Category.CADEIRAS, 1500.50, seller1, product1);
		Newpost newpost2 = new Newpost(null, sdf.parse("04-06-2021"), Category.HEADSETS, 2800.69, seller1, product2);
		Newpost newpost3 = new Newpost(null, sdf.parse("25-05-2021"), Category.MOUSES, 375.90, seller1, product3);
		Newpost newpost4 = new Newpost(null, sdf.parse("01-03-2019"), Category.TECLADOS, 1000.00, seller2, product4);
		Newpost newpost5 = new NewpostPromo(null, sdf.parse("08-06-2021"), Category.CADEIRAS, 5000.00, seller3, product5, true, 0.10);

		seller1.getFollowers().addAll(Arrays.asList(buyer1, buyer2, buyer3));
		seller2.getFollowers().addAll(Arrays.asList(buyer1, buyer2));
		seller3.getFollowers().addAll(Arrays.asList(buyer3));

		seller1.getNewposts().addAll(Arrays.asList(newpost1, newpost2, newpost3));
		seller2.getNewposts().addAll(Arrays.asList(newpost4));
		seller3.getNewposts().addAll(Arrays.asList(newpost5));

		buyer1.getFollowed().addAll(Arrays.asList(seller1,seller2));
		buyer2.getFollowed().addAll(Arrays.asList(seller1, seller2));
		buyer3.getFollowed().addAll(Arrays.asList(seller1, seller3));

		sellerRepository.saveAll(Arrays.asList(seller1, seller2, seller3));
		buyerRepository.saveAll(Arrays.asList(buyer2, buyer1, buyer3));
		newpostRepository.saveAll(Arrays.asList(newpost1, newpost2, newpost3, newpost4, newpost5));
		productRepository.saveAll(Arrays.asList(product1,product2, product3, product4, product5));

	}
}

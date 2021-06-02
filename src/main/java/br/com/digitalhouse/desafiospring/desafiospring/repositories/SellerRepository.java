package br.com.digitalhouse.desafiospring.desafiospring.repositories;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
}

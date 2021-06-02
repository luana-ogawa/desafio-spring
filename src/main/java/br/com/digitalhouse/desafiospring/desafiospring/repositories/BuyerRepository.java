package br.com.digitalhouse.desafiospring.desafiospring.repositories;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
}

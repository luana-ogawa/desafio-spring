package br.com.digitalhouse.desafiospring.desafiospring.repositories;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

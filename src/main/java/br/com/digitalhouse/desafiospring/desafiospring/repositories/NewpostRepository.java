package br.com.digitalhouse.desafiospring.desafiospring.repositories;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewpostRepository extends JpaRepository<Newpost, Integer> {
}

package br.com.digitalhouse.desafiospring.desafiospring.services;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Newpost;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Product;
import br.com.digitalhouse.desafiospring.desafiospring.domain.Seller;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.NewpostRepository;
import br.com.digitalhouse.desafiospring.desafiospring.repositories.ProductRepository;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.DataIntegrityException;
import br.com.digitalhouse.desafiospring.desafiospring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product insert(Product product) {
        product.setProduct_id(null);
        return productRepository.save(product);
    }

    public Product findProduct(Integer product_id) {
        Optional<Product> product = productRepository.findById(product_id);
        return product.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + product_id));
    }

    public void delete(Integer product_id) {
        findProduct(product_id);
        try {
            productRepository.deleteById(product_id);
        } catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um post que possui produtos");
        }

    }

}

package br.com.ismadrade.application.ports.in;

import br.com.ismadrade.application.core.domain.Product;

import java.util.List;

public interface ProductServicePort {
    Product create(Product product);
    List<Product> getAllProducts();
    Product findProductById(Long id);
    Product changeProduct(Long id, Product product);
    void deleteProduct(Long id);
}

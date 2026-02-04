package br.com.autoflex.service;

import java.util.List;
import java.util.UUID;

import br.com.autoflex.entity.Product;
import br.com.autoflex.exception.ObjectNotFoundException;
import br.com.autoflex.repository.ProductRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;

@Dependent
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product newProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    public List<Product> listProducts(Integer pageNumber, Integer pageSize) {
        return productRepository.findAll().page(pageNumber, pageSize).list();
    }

    public Product listProduct(UUID productId) {
        return productRepository.findByIdOptional(productId).orElseThrow(ObjectNotFoundException::new);
    }

    @Transactional
    public Product updateProduct(UUID productId, Product product) {
        Product currentProduct = listProduct(productId);
        currentProduct.setCode(product.getCode());
        currentProduct.setName(product.getName());
        currentProduct.setPrice(product.getPrice());
        productRepository.persist(currentProduct);
        return currentProduct;
    }

    @Transactional
    public void deleteProduct(UUID productId) {
        productRepository.delete(listProduct(productId));
    }

}

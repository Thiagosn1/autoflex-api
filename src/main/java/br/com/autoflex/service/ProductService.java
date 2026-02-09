package br.com.autoflex.service;

import java.util.List;
import java.util.UUID;
import br.com.autoflex.dto.mapper.ProductMapper;
import br.com.autoflex.dto.request.ProductRequestDTO;
import br.com.autoflex.dto.response.ProductResponseDTO;
import br.com.autoflex.entity.Product;
import br.com.autoflex.exception.ObjectNotFoundException;
import br.com.autoflex.repository.ProductRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;
import io.quarkus.panache.common.Page;

@Dependent
public class ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Transactional
    public ProductResponseDTO newProduct(ProductRequestDTO dto) {
        Product product = productMapper.toEntity(dto);
        productRepository.persist(product);
        return productMapper.toResponseDTO(product);
    }

    public List<Product> listProducts(Integer pageNumber, Integer pageSize) {
        if (pageNumber == null && pageSize == null) {
            return productRepository.listAll();
        }

        int pn = (pageNumber != null) ? pageNumber : 0;
        int ps = (pageSize != null) ? pageSize : 10;

        return productRepository.findAll()
                .page(Page.of(pn, ps))
                .list();
    }

    public ProductResponseDTO listProduct(UUID productId) {
        Product product = productRepository.findByIdOptional(productId)
                .orElseThrow(ObjectNotFoundException::new);
        return productMapper.toResponseDTO(product);
    }

    @Transactional
    public ProductResponseDTO updateProduct(UUID productId, ProductRequestDTO dto) {
        Product product = productRepository.findByIdOptional(productId)
                .orElseThrow(ObjectNotFoundException::new);
        productMapper.updateEntity(product, dto);
        return productMapper.toResponseDTO(product);
    }

    @Transactional
    public void deleteProduct(UUID productId) {
        Product product = productRepository.findByIdOptional(productId)
                .orElseThrow(ObjectNotFoundException::new);
        productRepository.delete(product);
    }

}

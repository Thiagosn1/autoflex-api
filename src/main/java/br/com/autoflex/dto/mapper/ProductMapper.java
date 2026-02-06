package br.com.autoflex.dto.mapper;

import br.com.autoflex.dto.request.ProductRequestDTO;
import br.com.autoflex.dto.response.ProductResponseDTO;
import br.com.autoflex.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();
        product.setCode(dto.getCode());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return product;
    }

    public void updateEntity(Product product, ProductRequestDTO dto) {
        product.setCode(dto.getCode());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
    }

    public ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getCode(),
                product.getName(),
                product.getPrice());
    }
}

package br.com.autoflex.dto.mapper;

import br.com.autoflex.dto.response.ProductRawMaterialResponseDTO;
import br.com.autoflex.entity.ProductRawMaterial;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRawMaterialMapper {

    public ProductRawMaterialResponseDTO toResponseDTO(ProductRawMaterial entity) {
        return new ProductRawMaterialResponseDTO(
                entity.getId(),
                entity.getProduct().getId(),
                entity.getProduct().getName(),
                entity.getRawMaterial().getId(),
                entity.getRawMaterial().getName(),
                entity.getQuantityRequired());

    }
}

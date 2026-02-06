package br.com.autoflex.dto.mapper;

import br.com.autoflex.dto.request.RawMaterialRequestDTO;
import br.com.autoflex.dto.response.RawMaterialResponseDTO;
import br.com.autoflex.entity.RawMaterial;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RawMaterialMapper {

    public RawMaterial toEntity(RawMaterialRequestDTO dto) {
        RawMaterial rawMaterial = new RawMaterial();
        rawMaterial.setCode(dto.getCode());
        rawMaterial.setName(dto.getName());
        rawMaterial.setQuantityInStock(dto.getQuantityInStock());
        return rawMaterial;
    }

    public void updateEntity(RawMaterial rawMaterial, RawMaterialRequestDTO dto) {
        rawMaterial.setCode(dto.getCode());
        rawMaterial.setName(dto.getName());
        rawMaterial.setQuantityInStock(dto.getQuantityInStock());
    }

    public RawMaterialResponseDTO toResponseDTO(RawMaterial rawMaterial) {
        return new RawMaterialResponseDTO(
                rawMaterial.getId(),
                rawMaterial.getCode(),
                rawMaterial.getName(),
                rawMaterial.getQuantityInStock());
    }
}

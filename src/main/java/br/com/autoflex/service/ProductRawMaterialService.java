package br.com.autoflex.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.autoflex.dto.mapper.ProductRawMaterialMapper;
import br.com.autoflex.dto.request.ProductRawMaterialRequestDTO;
import br.com.autoflex.dto.response.ProductRawMaterialResponseDTO;
import br.com.autoflex.entity.Product;
import br.com.autoflex.entity.ProductRawMaterial;
import br.com.autoflex.entity.RawMaterial;
import br.com.autoflex.exception.ObjectNotFoundException;
import br.com.autoflex.repository.ProductRawMaterialRepository;
import br.com.autoflex.repository.ProductRepository;
import br.com.autoflex.repository.RawMaterialRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;

@Dependent
public class ProductRawMaterialService {
    ProductRawMaterialRepository productRawMaterialRepository;
    ProductRepository productRepository;
    RawMaterialRepository rawMaterialRepository;
    ProductRawMaterialMapper productRawMaterialMapper;

    public ProductRawMaterialService(ProductRawMaterialRepository productRawMaterialRepository,
            ProductRepository productRepository,
            RawMaterialRepository rawMaterialRepository,
            ProductRawMaterialMapper productRawMaterialMapper) {
        this.productRawMaterialRepository = productRawMaterialRepository;
        this.productRepository = productRepository;
        this.rawMaterialRepository = rawMaterialRepository;
        this.productRawMaterialMapper = productRawMaterialMapper;
    }

    @Transactional
    public ProductRawMaterialResponseDTO createAssociation(ProductRawMaterialRequestDTO dto) {
        Product product = productRepository.findByIdOptional(dto.getProductId())
                .orElseThrow(() -> new ObjectNotFoundException());

        RawMaterial rawMaterial = rawMaterialRepository.findByIdOptional(dto.getRawMaterialId())
                .orElseThrow(() -> new ObjectNotFoundException());

        ProductRawMaterial association = new ProductRawMaterial(product, rawMaterial, dto.getQuantityRequired());

        productRawMaterialRepository.persist(association);
        return productRawMaterialMapper.toResponseDTO(association);
    }

    public List<ProductRawMaterialResponseDTO> listAll() {
        return productRawMaterialRepository.listAll()
                .stream()
                .map(productRawMaterialMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<ProductRawMaterialResponseDTO> listByProduct(UUID productId) {
        // Validate that product exists
        productRepository.findByIdOptional(productId)
                .orElseThrow(() -> new ObjectNotFoundException());

        return productRawMaterialRepository.findByProductId(productId)
                .stream()
                .map(productRawMaterialMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductRawMaterialResponseDTO getById(UUID id) {
        ProductRawMaterial association = productRawMaterialRepository.findByIdOptional(id)
                .orElseThrow(() -> new ObjectNotFoundException());
        return productRawMaterialMapper.toResponseDTO(association);
    }

    @Transactional
    public ProductRawMaterialResponseDTO updateAssociation(UUID id, ProductRawMaterialRequestDTO dto) {
        ProductRawMaterial association = productRawMaterialRepository.findByIdOptional(id)
                .orElseThrow(() -> new ObjectNotFoundException());

        association.setQuantityRequired(dto.getQuantityRequired());
        return productRawMaterialMapper.toResponseDTO(association);
    }

    @Transactional
    public void deleteAssociation(UUID id) {
        ProductRawMaterial association = productRawMaterialRepository.findByIdOptional(id)
                .orElseThrow(() -> new ObjectNotFoundException());
        productRawMaterialRepository.delete(association);
    }

}

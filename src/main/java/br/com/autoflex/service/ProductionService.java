package br.com.autoflex.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import br.com.autoflex.dto.response.ProductionSuggestionDTO;
import br.com.autoflex.dto.response.ProductionSuggestionItemDTO;
import br.com.autoflex.entity.Product;
import br.com.autoflex.entity.ProductRawMaterial;
import br.com.autoflex.entity.RawMaterial;
import br.com.autoflex.repository.ProductRepository;
import br.com.autoflex.repository.RawMaterialRepository;
import jakarta.enterprise.context.Dependent;

@Dependent
public class ProductionService {

    ProductRepository productRepository;
    RawMaterialRepository rawMaterialRepository;

    public ProductionService(ProductRepository productRepository,
            RawMaterialRepository rawMaterialRepository) {
        this.productRepository = productRepository;
        this.rawMaterialRepository = rawMaterialRepository;
    }

    public ProductionSuggestionDTO calculateProductionSuggestion() {

        Map<UUID, BigDecimal> virtualStock = createVirtualStockMap();

        List<Product> products = productRepository.findProductsWithRawMaterials();

        List<ProductionSuggestionItemDTO> suggestions = new ArrayList<>();

        for (Product product : products) {
            BigDecimal maxQuantity = calculateMaxProducibleQuantity(product, virtualStock);

            if (maxQuantity.compareTo(BigDecimal.ZERO) > 0) {
                ProductionSuggestionItemDTO suggestion = new ProductionSuggestionItemDTO(
                        product.getId(),
                        product.getCode(),
                        product.getName(),
                        product.getPrice(),
                        maxQuantity);
                suggestions.add(suggestion);

                consumeRawMaterials(product, maxQuantity, virtualStock);
            }
        }

        return new ProductionSuggestionDTO(suggestions);
    }

    private Map<UUID, BigDecimal> createVirtualStockMap() {
        Map<UUID, BigDecimal> stockMap = new HashMap<>();
        List<RawMaterial> rawMaterials = rawMaterialRepository.listAll();

        for (RawMaterial rawMaterial : rawMaterials) {
            stockMap.put(rawMaterial.getId(), rawMaterial.getQuantityInStock());
        }

        return stockMap;
    }

    private BigDecimal calculateMaxProducibleQuantity(Product product, Map<UUID, BigDecimal> virtualStock) {
        if (product.getRawMaterials().isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal maxQuantity = null;

        for (ProductRawMaterial productRawMaterial : product.getRawMaterials()) {
            UUID rawMaterialId = productRawMaterial.getRawMaterial().getId();
            BigDecimal quantityRequired = productRawMaterial.getQuantityRequired();
            BigDecimal availableStock = virtualStock.getOrDefault(rawMaterialId, BigDecimal.ZERO);

            BigDecimal possibleQuantity;
            if (quantityRequired.compareTo(BigDecimal.ZERO) > 0) {
                possibleQuantity = availableStock.divide(quantityRequired, 0, RoundingMode.DOWN);
            } else {
                possibleQuantity = BigDecimal.ZERO;
            }

            if (maxQuantity == null || possibleQuantity.compareTo(maxQuantity) < 0) {
                maxQuantity = possibleQuantity;
            }
        }

        return maxQuantity != null ? maxQuantity : BigDecimal.ZERO;
    }

    private void consumeRawMaterials(Product product, BigDecimal quantity, Map<UUID, BigDecimal> virtualStock) {
        for (ProductRawMaterial productRawMaterial : product.getRawMaterials()) {
            UUID rawMaterialId = productRawMaterial.getRawMaterial().getId();
            BigDecimal quantityRequired = productRawMaterial.getQuantityRequired();
            BigDecimal totalConsumption = quantityRequired.multiply(quantity);

            BigDecimal currentStock = virtualStock.get(rawMaterialId);
            BigDecimal newStock = currentStock.subtract(totalConsumption);
            virtualStock.put(rawMaterialId, newStock);
        }
    }
}
package br.com.autoflex.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductRawMaterialRequestDTO {

    @NotNull(message = "Product is required")
    private UUID productId;

    @NotNull(message = "Raw Material is required")
    private UUID rawMaterialId;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity required must be greater than zero")
    private BigDecimal quantityRequired;

    public ProductRawMaterialRequestDTO() {
    }

    public ProductRawMaterialRequestDTO(UUID productId, UUID rawMaterialId, BigDecimal quantityRequired) {
        this.productId = productId;
        this.rawMaterialId = rawMaterialId;
        this.quantityRequired = quantityRequired;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public UUID getRawMaterialId() {
        return rawMaterialId;
    }

    public void setRawMaterialId(UUID rawMaterialId) {
        this.rawMaterialId = rawMaterialId;
    }

    public BigDecimal getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(BigDecimal quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

}

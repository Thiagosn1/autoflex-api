package br.com.autoflex.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductRawMaterialResponseDTO {

    private UUID id;
    private UUID productId;
    private String productName;
    private UUID rawMaterialId;
    private String rawMaterialName;
    private BigDecimal quantityRequired;

    public ProductRawMaterialResponseDTO() {
    }

    public ProductRawMaterialResponseDTO(UUID id, UUID productId, String productName, UUID rawMaterialId,
            String rawMaterialName, BigDecimal quantityRequired) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.rawMaterialId = rawMaterialId;
        this.rawMaterialName = rawMaterialName;
        this.quantityRequired = quantityRequired;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public UUID getRawMaterialId() {
        return rawMaterialId;
    }

    public void setRawMaterialId(UUID rawMaterialId) {
        this.rawMaterialId = rawMaterialId;
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public BigDecimal getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(BigDecimal quantityRequired) {
        this.quantityRequired = quantityRequired;
    }
}

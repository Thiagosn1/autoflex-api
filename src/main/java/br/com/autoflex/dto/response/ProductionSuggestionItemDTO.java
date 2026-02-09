package br.com.autoflex.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductionSuggestionItemDTO {

    private UUID productId;
    private String productCode;
    private String productName;
    private BigDecimal productPrice;
    private BigDecimal quantityToProduce;
    private BigDecimal totalValue;

    public ProductionSuggestionItemDTO() {
    }

    public ProductionSuggestionItemDTO(UUID productId, String productCode, String productName,
            BigDecimal productPrice, BigDecimal quantityToProduce) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantityToProduce = quantityToProduce;
        this.totalValue = productPrice.multiply(quantityToProduce);
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getQuantityToProduce() {
        return quantityToProduce;
    }

    public void setQuantityToProduce(BigDecimal quantityToProduce) {
        this.quantityToProduce = quantityToProduce;
        if (this.productPrice != null && quantityToProduce != null) {
            this.totalValue = this.productPrice.multiply(quantityToProduce);
        }
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
package br.com.autoflex.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class RawMaterialRequestDTO {

    @NotBlank(message = "Code is required")
    private String code;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Quantity in stock is required")
    @PositiveOrZero(message = "Quantity in stock must be zero or positive")
    private BigDecimal quantityInStock;

    public RawMaterialRequestDTO() {

    }

    public RawMaterialRequestDTO(String code, String name, BigDecimal quantityInStock) {
        this.code = code;
        this.name = name;
        this.quantityInStock = quantityInStock;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(BigDecimal quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

}

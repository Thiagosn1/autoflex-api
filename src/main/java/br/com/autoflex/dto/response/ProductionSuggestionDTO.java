package br.com.autoflex.dto.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductionSuggestionDTO {

    private List<ProductionSuggestionItemDTO> suggestions;
    private BigDecimal totalProductionValue;

    public ProductionSuggestionDTO() {
        this.suggestions = new ArrayList<>();
        this.totalProductionValue = BigDecimal.ZERO;
    }

    public ProductionSuggestionDTO(List<ProductionSuggestionItemDTO> suggestions) {
        this.suggestions = suggestions;
        this.totalProductionValue = suggestions.stream()
                .map(ProductionSuggestionItemDTO::getTotalValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<ProductionSuggestionItemDTO> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<ProductionSuggestionItemDTO> suggestions) {
        this.suggestions = suggestions;
        this.totalProductionValue = suggestions.stream()
                .map(ProductionSuggestionItemDTO::getTotalValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalProductionValue() {
        return totalProductionValue;
    }

    public void setTotalProductionValue(BigDecimal totalProductionValue) {
        this.totalProductionValue = totalProductionValue;
    }

    public void addSuggestion(ProductionSuggestionItemDTO item) {
        this.suggestions.add(item);
        this.totalProductionValue = this.totalProductionValue.add(item.getTotalValue());
    }
}

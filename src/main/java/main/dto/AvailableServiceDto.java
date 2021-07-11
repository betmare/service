package main.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AvailableServiceDto {
    private int id;
    private String name;
    private String code;
    private String description;
    private int suggestedDuration;
    private BigDecimal suggestedPrice;
}

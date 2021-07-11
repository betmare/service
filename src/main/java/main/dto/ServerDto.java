package main.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerDto {

    private int id;
    private Boolean active;
    private BigDecimal price;
    private int duration;
    private int userId;
    private int availableServiceId;
}

package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class AvailableScheduleDto implements Serializable {
    private Integer availabilityId;
    private String serviceName;
    private String userName;
    private String userLastname;
}

package main.service;

import main.dto.AvailableServiceDto;
import main.dto.EntityResponse;
import main.model.AvailableService;
import main.repository.AvailableServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailableServiceService {

    @Autowired
    private AvailableServiceRepository availableServiceRepository;

    public EntityResponse searchAvailableServices( final String serviceToSearch ) {
        try {
            List<AvailableService> availableServices = availableServiceRepository.findByNameContainingIgnoreCase(serviceToSearch);
            final List<AvailableServiceDto> availableServiceDtos = new ArrayList<>();
            availableServices.forEach( service -> availableServiceDtos.add(AvailableServiceDto.builder()
                    .id(service.getId())
                    .code(service.getCode())
                    .description(service.getDescription())
                    .name(service.getName())
                    .suggestedDuration(service.getSuggestedDuration())
                    .suggestedPrice(service.getSuggestedPrice())
                    .build()));
            error
            return EntityResponse.builder().entity(availableServiceDtos).statusCode(HttpStatus.OK).build();
        } catch (Exception e)
        {
            return EntityResponse.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR).error(e.getMessage()).build();
        }
    }
}

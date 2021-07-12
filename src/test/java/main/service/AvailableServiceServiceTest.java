package main.service;


import main.dto.AvailableServiceDto;
import main.dto.EntityResponse;
import main.model.AvailableService;
import main.repository.AvailableServiceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AvailableServiceServiceTest {
    @Spy
    private AvailableServiceRepository availableServiceRepository;

    @InjectMocks
    private AvailableServiceService availableServiceService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchAvailableServiceByName() {
        String name = "limpieza";
        List<AvailableService> availableServices = new ArrayList<>();
        availableServices.add(AvailableService.builder()
                .id(1)
                .name("limpieza de hogar")
                .code("limpieza.hogar")
                .description("Limpieza de Hogar")
                .suggestedDuration(5)
                .suggestedPrice(new BigDecimal("10.50"))
                .build());
        final List<AvailableServiceDto> availableServiceDtos = new ArrayList<>();
        availableServices.forEach( service -> availableServiceDtos.add(AvailableServiceDto.builder()
                .id(service.getId())
                .code(service.getCode())
                .description(service.getDescription())
                .name(service.getName())
                .suggestedDuration(service.getSuggestedDuration())
                .suggestedPrice(service.getSuggestedPrice())
                .build()));
        Mockito.when(availableServiceRepository.findByNameContainingIgnoreCase(name)).thenReturn(availableServices);
        EntityResponse entityResponse = availableServiceService.searchAvailableServices(name);
        Assert.assertEquals(entityResponse.getEntity(), availableServiceDtos);
        Assert.assertNull(entityResponse.getError());
        Assert.assertEquals(entityResponse.getStatusCode(), HttpStatus.OK);
        // Assert.assertEquals(entityResponse.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

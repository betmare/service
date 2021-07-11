package main.controller;

import main.dto.EntityResponse;
import main.service.AvailableServiceService;
import main.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/available-service")
public class AvailableServiceController {

    @Autowired
    private AvailableServiceService availableServiceService;

    @GetMapping("/search")
    public ResponseEntity<Object> getServices(@RequestParam String serviceToSearch ) {
        EntityResponse entityResponse = availableServiceService.searchAvailableServices(serviceToSearch);
        return ResponseUtil.buildResponse(entityResponse.getEntity(), entityResponse.getStatusCode(), entityResponse.getError());
    }
}

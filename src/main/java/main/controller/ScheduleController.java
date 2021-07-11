package main.controller;


import main.dto.AvailabilityDto;
import main.dto.EntityResponse;
import main.service.ScheduleService;
import main.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseEntity<Object> setSchedule(@RequestBody AvailabilityDto availabilityDto) {
        EntityResponse entityResponse = scheduleService.storeAvailability(availabilityDto);
        return ResponseUtil.buildResponse(entityResponse.getEntity(), entityResponse.getStatusCode(), entityResponse.getError());
    }

    @GetMapping(path = "/search-schedule")
    @ResponseBody
    public ResponseEntity<Object> getSearchAvailability() {
        return null;
    }
}

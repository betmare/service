package main.service;

import main.dto.AvailabilityDto;
import main.dto.EntityResponse;
import main.model.Availability;
import main.repository.AvailabilityRepository;
import main.repository.ServerRepository;
import main.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private ServerRepository serverRepository;

    public EntityResponse storeAvailability(final AvailabilityDto availabilityDto ) {
        try {
            Availability availability = Availability.builder()
                    .monday(Utility.checkBooleanNullFalse(availabilityDto.getMonday()))
                    .tuesday(Utility.checkBooleanNullFalse(availabilityDto.getTuesday()))
                    .wednesday(Utility.checkBooleanNullFalse(availabilityDto.getWednesday()))
                    .thursday(Utility.checkBooleanNullFalse(availabilityDto.getThursday()))
                    .friday(Utility.checkBooleanNullFalse(availabilityDto.getFriday()))
                    .saturday(Utility.checkBooleanNullFalse(availabilityDto.getSaturday()))
                    .sunday(Utility.checkBooleanNullFalse(availabilityDto.getSunday()))
                    .price(availabilityDto.getPricePerHour())
                    .timeFrom(availabilityDto.getTimeFrom())
                    .timeTo(availabilityDto.getTimeTo())
                    .server(serverRepository.getById(availabilityDto.getServerId()))
                    .build();
            Availability availabilitySaved = availabilityRepository.save(availability);
            availabilityDto.setId(availabilitySaved.getId());
            return EntityResponse.builder().entity(availabilityDto).statusCode(HttpStatus.OK).build();
        } catch (Exception e) {
            return EntityResponse.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .error("Error registrando disponibilidad")
                    .build();
        }
    }

}

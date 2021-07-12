package main.repository;

import main.dto.AvailableScheduleDto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AvailableScheduleRepositoryCustom {
    List<AvailableScheduleDto> getAvailableSchedule(int availableServiceId, LocalDate requestDate, LocalTime fromTime, LocalTime toTime);
}

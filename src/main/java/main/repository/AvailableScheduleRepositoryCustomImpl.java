package main.repository;

import main.dto.AvailableScheduleDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AvailableScheduleRepositoryCustomImpl implements AvailableScheduleRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<AvailableScheduleDto> getAvailableSchedule(int availableServiceId, LocalDate requestDate, LocalTime fromTime, LocalTime toTime) {
        DayOfWeek dayOfWeek = requestDate.getDayOfWeek();
        StringBuilder queryBuffer = new StringBuilder();
        queryBuffer.append("SELECT a.id, as.name, u.firstname, u.lastname FROM availability a ");
        queryBuffer.append("JOIN server s ON s.id = a.server_id ");
        queryBuffer.append("JOIN available_service as ON as.id = s.available_service_id ");
        queryBuffer.append("AND as.id = ").append(availableServiceId).append(" ");
        queryBuffer.append("JOIN user u ON u.id = s.user_id ");
        queryBuffer.append("WHERE 1 ");
        queryBuffer.append(addAvailabilityByDayQuery(dayOfWeek));

        return null;
    }

    private String addAvailabilityByDayQuery(DayOfWeek dayOfWeek) {
        StringBuilder queryPortion = new StringBuilder();
        switch (dayOfWeek) {
            case MONDAY:
                queryPortion.append(" AND a.monday IS TRUE ");
                break;
            case TUESDAY:
                queryPortion.append(" AND a.tuesday IS TRUE ");
                break;
            case WEDNESDAY:
                queryPortion.append(" AND a.wednesday IS TRUE ");
                break;
            case THURSDAY:
                queryPortion.append(" AND a.THURSDAY IS TRUE ");
                break;
            case FRIDAY:
                queryPortion.append(" AND a.FRIDAY IS TRUE ");
                break;
            case SATURDAY:
                queryPortion.append(" AND a.SATURDAY IS TRUE ");
                break;
            case SUNDAY:
                queryPortion.append(" AND a.SUNDAY IS TRUE ");
                break;
        }
        return queryPortion.toString();
    }
}

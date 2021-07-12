package main.repository;

import main.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository  extends JpaRepository<Availability, Integer>, AvailableScheduleRepositoryCustom {

}

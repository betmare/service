package main.repository;

import main.model.AvailableService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableServiceRepository extends JpaRepository<AvailableService, Integer> {
    List<AvailableService> findByNameContainingIgnoreCase(String name);
}

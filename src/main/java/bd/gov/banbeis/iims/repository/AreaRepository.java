package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.institute.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AreaRepository extends JpaRepository<Area, UUID> {
    Boolean existsByAreaIgnoreCase(String area);

    Area findByAreaIgnoreCase(String area);
}

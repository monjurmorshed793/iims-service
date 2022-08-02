package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.institute.Geography;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GeographyRepository extends JpaRepository<Geography, UUID> {
    Boolean existsByGeographyIgnoreCase(String geography);

    Geography findByGeographyIgnoreCase(String geography);
}

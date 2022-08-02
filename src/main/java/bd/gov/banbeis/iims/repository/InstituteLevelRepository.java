package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.institute.InstituteLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstituteLevelRepository extends JpaRepository<InstituteLevel, UUID> {
    Boolean existsByLevelIgnoreCase(String level);

    InstituteLevel getByLevelIgnoreCase(String level);
}

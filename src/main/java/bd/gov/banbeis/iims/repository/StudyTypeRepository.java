package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.institute.StudyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudyTypeRepository extends JpaRepository<StudyType, UUID> {
    Boolean existsByTypeIgnoreCase(String type);

    StudyType findByTypeIgnoreCase(String type);
}

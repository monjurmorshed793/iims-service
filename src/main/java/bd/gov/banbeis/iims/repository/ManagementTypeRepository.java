package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.institute.ManagementType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManagementTypeRepository extends JpaRepository<ManagementType, UUID> {
    Boolean existsByTypeIgnoreCase(String type);

    ManagementType getByTypeIgnoreCase(String type);
}

package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.institute.InstituteType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstituteTypeRepository extends JpaRepository<InstituteType, UUID> {
    Boolean existsByTypeIgnoreCase(String type);

    InstituteType getByTypeIgnoreCase(String type);

}

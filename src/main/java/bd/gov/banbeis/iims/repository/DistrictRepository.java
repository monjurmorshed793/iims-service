package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.institute.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DistrictRepository extends JpaRepository<District, UUID> {
    Boolean existsByNameIgnoreCase(String name);

    District getByNameIgnoreCase(String name);
}

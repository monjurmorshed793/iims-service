package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.institute.InstituteRaw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstituteRawRepository extends JpaRepository<InstituteRaw, UUID> {
}

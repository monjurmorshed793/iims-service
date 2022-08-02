package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.institute.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstituteRepository extends JpaRepository<Institute, UUID> {

}

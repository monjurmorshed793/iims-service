package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.institute.Upazila;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UpazilaRepository extends JpaRepository<Upazila, UUID> {
    Boolean existsByNameIgnoreCase(String name);

    Upazila getByNameIgnoreCase(String name);
}

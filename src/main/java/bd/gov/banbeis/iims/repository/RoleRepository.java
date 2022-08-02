package bd.gov.banbeis.iims.repository;

import bd.gov.banbeis.iims.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}

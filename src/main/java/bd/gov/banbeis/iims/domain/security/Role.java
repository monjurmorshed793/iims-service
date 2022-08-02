package bd.gov.banbeis.iims.domain.security;

import bd.gov.banbeis.iims.domain.AbstractAuditLog;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Role extends AbstractAuditLog {
    @Id
    @GeneratedValue
    private UUID id;
    private String role;
}

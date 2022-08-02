package bd.gov.banbeis.iims.domain.security;

import bd.gov.banbeis.iims.domain.AbstractAuditLog;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Role extends AbstractAuditLog {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(length = 15)
    private String role;
}

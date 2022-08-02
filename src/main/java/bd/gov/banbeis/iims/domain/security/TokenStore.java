package bd.gov.banbeis.iims.domain.security;

import bd.gov.banbeis.iims.domain.AbstractAuditLog;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Table(name = "token_store")
@EntityListeners(AuditingEntityListener.class)
public class TokenStore extends AbstractAuditLog {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @NotNull
    private User user;

    @NotNull
    private String token;

    @NotNull
    private Instant validTill;
}

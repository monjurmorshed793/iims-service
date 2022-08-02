package bd.gov.banbeis.iims.domain.security;

import bd.gov.banbeis.iims.domain.AbstractAuditLog;
import bd.gov.banbeis.iims.serializer.BCryptPasswordDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "user", indexes = @Index(columnList = "username, email, mobile"))
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractAuditLog {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true,length = 25)
    @NotNull
    private String username;

    @JsonDeserialize(using = BCryptPasswordDeserializer.class)
    private String password;

    @Column(length = 25)
    private String rawPassword;

    private Instant tokenValidTill;

    @Column(length = 50)
    private String email;

    @Column(length = 15)
    private String mobile;

    @OneToMany(mappedBy = "role", cascade = CascadeType.DETACH)
    private List<Role> roles = new ArrayList<>();

    private Boolean isAccountExpired;

    private Boolean isAccountLocked;

    private Boolean isCredentialsExpired;

    private Boolean isEnabled;
}

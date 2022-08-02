package bd.gov.banbeis.iims.domain.security;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private Instant tokenValidTill;

    private String email;

    private String mobile;

    @OneToMany(mappedBy = "role", cascade = CascadeType.DETACH)
    private List<Role> roles = new ArrayList<>();

    private Boolean isAccountExpired;

    private Boolean isAccountLocked;

    private Boolean isCredentialsExpired;

    private Boolean isEnabled;
}

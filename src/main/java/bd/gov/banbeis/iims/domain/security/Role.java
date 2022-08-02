package bd.gov.banbeis.iims.domain.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue
    private UUID id;
    private String role;
}

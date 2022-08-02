package bd.gov.banbeis.iims.domain.institute;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class InstituteLevel {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(length = 15)
    private String level;
}

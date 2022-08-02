package bd.gov.banbeis.iims.domain.institute;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Area {
    @Id
    @GeneratedValue
    private UUID id;
    private String area;
}

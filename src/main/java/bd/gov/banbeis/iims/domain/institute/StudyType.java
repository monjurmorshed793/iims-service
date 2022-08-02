package bd.gov.banbeis.iims.domain.institute;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class StudyType {
    @Id
    @GeneratedValue
    private UUID id;
    private String type;
}

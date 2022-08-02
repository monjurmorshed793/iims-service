package bd.gov.banbeis.iims.domain.institute;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(indexes = @Index(columnList = "name"))
public class District {
    @Id
    @GeneratedValue
    private UUID id ;

    @Column(length = 50)
    private String name;

}

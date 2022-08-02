package bd.gov.banbeis.iims.domain.institute;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(indexes = @Index(columnList = "name, district_id"))
public class Upazila {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;
    @Column(length = 50)
    private String name;
}

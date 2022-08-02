package bd.gov.banbeis.iims.domain.institute;

import bd.gov.banbeis.iims.domain.AbstractAuditLog;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Institute extends AbstractAuditLog {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
    @ManyToOne
    @JoinColumn(name = "upazila_id")
    private Upazila upazila;
    @ManyToOne
    @JoinColumn(name="institute_type_id")
    private InstituteType instituteType;
    @ManyToOne
    @JoinColumn(name="institute_level_id")
    private InstituteLevel instituteLevel;
    private String eiin;
    private String name;
    private String address;
    private String post;
    private String mobile;
    @ManyToOne
    @JoinColumn(name = "management_type_id")
    private ManagementType managementType;
    private Boolean isMpo;
    @ManyToOne
    @JoinColumn(name="study_type_id")
    private StudyType studyType;
    @ManyToOne
    @JoinColumn(name="area_id")
    private Area area;
    @ManyToOne
    @JoinColumn(name = "geography_id")
    private Geography geography;
}

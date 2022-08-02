package bd.gov.banbeis.iims.domain.institute;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Table(name="institute_raw")
public class InstituteRaw {
    @Id
    @GeneratedValue
    private UUID id;
    private String district;
    private String upazila;
    private String instituteType;
    private String instituteLevel;
    private String eiin;
    private String instituteName;
    private String address;
    private String post;
    private String mobile;
    private String management;
    private String mpo;
    private String studyType;
    private String area;
    private String geography;
}

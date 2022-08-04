package bd.gov.banbeis.iims.domain.institute;

import bd.gov.banbeis.iims.listener.InstituteRawListener;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="institute_raw")
@EntityListeners(InstituteRawListener.class)
public class InstituteRaw {
    @Id
    @GeneratedValue
    private UUID id = UUID.randomUUID();
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

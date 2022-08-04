package bd.gov.banbeis.iims.listener;

import bd.gov.banbeis.iims.domain.institute.*;
import bd.gov.banbeis.iims.repository.*;
import liquibase.pro.packaged.G;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import java.util.UUID;

@Component
public class InstituteRawListener {
    private static InstituteRepository instituteRepository;
    private static UpazilaRepository upazilaRepository;
    private static DistrictRepository districtRepository;
    private static AreaRepository areaRepository;
    private static GeographyRepository geographyRepository;
    private static InstituteLevelRepository instituteLevelRepository;
    private static InstituteTypeRepository instituteTypeRepository;
    private static ManagementTypeRepository managementTypeRepository;
    private static StudyTypeRepository studyTypeRepository;

    private InstituteRaw instituteRaw = new InstituteRaw();
    private Institute institute = new Institute();

    @Autowired
    public static void setInstituteRepository(InstituteRepository instituteRepository) {
        InstituteRawListener.instituteRepository = instituteRepository;
    }
    @Autowired
    public static void setUpazilaRepository(UpazilaRepository upazilaRepository) {
        InstituteRawListener.upazilaRepository = upazilaRepository;
    }
    @Autowired
    public static void setDistrictRepository(DistrictRepository districtRepository) {
        InstituteRawListener.districtRepository = districtRepository;
    }
    @Autowired
    public static void setAreaRepository(AreaRepository areaRepository) {
        InstituteRawListener.areaRepository = areaRepository;
    }
    @Autowired
    public static void setGeographyRepository(GeographyRepository geographyRepository) {
        InstituteRawListener.geographyRepository = geographyRepository;
    }
    @Autowired
    public static void setInstituteLevelRepository(InstituteLevelRepository instituteLevelRepository) {
        InstituteRawListener.instituteLevelRepository = instituteLevelRepository;
    }
    @Autowired
    public static void setInstituteTypeRepository(InstituteTypeRepository instituteTypeRepository) {
        InstituteRawListener.instituteTypeRepository = instituteTypeRepository;
    }
    @Autowired
    public static void setManagementTypeRepository(ManagementTypeRepository managementTypeRepository) {
        InstituteRawListener.managementTypeRepository = managementTypeRepository;
    }
    @Autowired
    public static void setStudyTypeRepository(StudyTypeRepository studyTypeRepository) {
        InstituteRawListener.studyTypeRepository = studyTypeRepository;
    }

    @PrePersist
    private void beforeInsert(InstituteRaw instituteRaw){
        instituteRaw.setId(UUID.randomUUID());
    }


    @PostPersist
    private void afterInsert(InstituteRaw instituteRaw){
        this.instituteRaw = instituteRaw;
        institute.setEiin(instituteRaw.getEiin());
        institute.setName(instituteRaw.getInstituteName());
        institute.setAddress(instituteRaw.getAddress());
        institute.setPost(instituteRaw.getPost());
        institute.setMobile(instituteRaw.getMobile());
        institute.setIsMpo(instituteRaw.getMpo().equalsIgnoreCase("yes")? true: false);

        updateDistrict();
        updateInstituteType();
        updateInstituteLevel();
        updateManagementType();
        updateStudyType();
        updateArea();
        updateGeography();
    }

    private void updateGeography(){
        String geographyRaw = this.instituteRaw.getGeography();
        Geography geography = new Geography();
        if(!geographyRepository.existsByGeographyIgnoreCase(geographyRaw)){
            geography.setGeography(geographyRaw);
            geography = geographyRepository.save(geography);
        }else{
            geography = geographyRepository.findByGeographyIgnoreCase(geographyRaw);
        }
        this.institute.setGeography(geography);
    }

    private void updateArea(){
        String areaRaw = this.instituteRaw.getArea();
        Area area = new Area();
        if(!areaRepository.existsByAreaIgnoreCase(areaRaw)){
            area.setArea(areaRaw);
            area = areaRepository.save(area);
        }else{
            area = areaRepository.findByAreaIgnoreCase(areaRaw);
        }
        this.institute.setArea(area);
    }

    private void updateStudyType(){
        String studyTypeRaw = this.instituteRaw.getStudyType();
        StudyType studyType = new StudyType();
        if(!studyTypeRepository.existsByTypeIgnoreCase(studyTypeRaw)){
            studyType.setType(studyTypeRaw);
            studyType = studyTypeRepository.save(studyType);
        }else{
            studyType = studyTypeRepository.findByTypeIgnoreCase(studyTypeRaw);
        }
        this.institute.setStudyType(studyType);
    }

    private void updateManagementType(){
        String management  = this.instituteRaw.getManagement();
        ManagementType managementType = new ManagementType();
        if(!managementTypeRepository.existsByTypeIgnoreCase(management)){
            managementType.setType(management);
            managementType = managementTypeRepository.save(managementType);
        }else{
            managementType = managementTypeRepository.getByTypeIgnoreCase(management);
        }

        this.institute.setManagementType(managementType);
    }

    private void updateInstituteLevel(){
        InstituteLevel instituteLevel = new InstituteLevel();
        if(!instituteLevelRepository.existsByLevelIgnoreCase(this.instituteRaw.getInstituteLevel())){
            instituteLevel.setLevel(this.instituteRaw.getInstituteLevel());
            instituteLevel = instituteLevelRepository.save(instituteLevel);
        }else{
            instituteLevel = instituteLevelRepository.getByLevelIgnoreCase(this.instituteRaw.getInstituteLevel());
        }
        this.institute.setInstituteLevel(instituteLevel);
    }

    private void updateInstituteType(){
        InstituteType instituteType = new InstituteType();
        if(!instituteTypeRepository.existsByTypeIgnoreCase(this.instituteRaw.getInstituteType())){
            instituteType.setType(this.instituteRaw.getInstituteType());
            instituteType = instituteTypeRepository.save(instituteType);
        }else{
            instituteType = instituteTypeRepository.getByTypeIgnoreCase(this.instituteRaw.getInstituteType());
        }
        this.institute.setInstituteType(instituteType);
    }

    private void updateDistrict(){
        District district= new District();
        String districtName = this.instituteRaw.getDistrict();
        if(!districtRepository.existsByNameIgnoreCase(districtName)){
            district.setName(districtName);
            district = districtRepository.save(district);
        }else{
            district = districtRepository.getByNameIgnoreCase(districtName);
        }
        this.institute.setDistrict(district);
        updateUpazila(district);
    }

    private void updateUpazila(District district){
        String upazilaName = this.instituteRaw.getUpazila();

        Upazila upazila = new Upazila();
        if(!upazilaRepository.existsByNameIgnoreCase(upazilaName)){
            upazila.setName(upazilaName);
            upazila.setDistrict(district);
            upazilaRepository.save(upazila);
        }else{
            upazila = upazilaRepository.getByNameIgnoreCase(upazilaName);
        }
        this.institute.setUpazila(upazila);
    }
}

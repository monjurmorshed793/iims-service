package bd.gov.banbeis.iims.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.time.Instant;

@Getter
@Setter
public abstract class AbstractAuditLog {
    @CreatedDate
    private Instant createdOn;
    @LastModifiedDate
    private Instant modifiedOn;
    @CreatedBy
    @Column(length = 25)
    private String createdBy;
    @LastModifiedBy
    @Column(length = 25)
    private String modifiedBy;
}

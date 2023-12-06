package hms.pms.infrastructure.jpa.entities.prescription;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "prescription")
public class PrescriptionJpaEntity {
    @Id
    @GeneratedValue
    @Column(name = "prescriptionid", nullable = false)
    private UUID prescriptionId;

    @Column(name = "drugnumber", nullable = false)
    private String drugNumber;

    @Column(name = "drugname", nullable = false)
    private String drugName;

    @Column(name = "unitsbyday", nullable = false)
    private int unitsByDay;

    @Column(name = "numberofadminsperday", nullable = false)
    private int numberOfAdminsPerDay;

    @Column(name = "methodofadministration", nullable = false)
    private String methodOfAdministration;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "startdate")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "finishdate")
    private Date finishDate;

    @Column(name = "patient_id")
    private UUID patient_id;
}

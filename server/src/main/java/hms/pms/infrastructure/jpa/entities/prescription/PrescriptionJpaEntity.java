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
    @Column(name = "prescription_id", nullable = false)
    private UUID prescriptionId;

    @Column(name = "drug_number", nullable = false)
    private String drugNumber;

    @Column(name = "drug_name", nullable = false)
    private String drugName;

    @Column(name = "units_by_day", nullable = false)
    private int unitsByDay;

    @Column(name = "number_of_admins_per_day", nullable = false)
    private int numberOfAdminsPerDay;

    @Column(name = "method_of_administration", nullable = false)
    private String methodOfAdministration;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "finish_date")
    private Date finishDate;

    @Column(name = "patient_id")
    private UUID patient_id;
}

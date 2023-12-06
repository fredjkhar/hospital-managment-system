package hms.pms.infrastructure.jpa.entities.ward;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ward")
public class WardJpaEntity {

    @Id
    @GeneratedValue
    @Column(name = "wardid")
    private UUID wardId;

    @Column(name = "wardname", nullable = false)
    private String wardName;

    @Column(name = "chargenurseid")
    private UUID chargeNurseId;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "totalbeds", nullable = false)
    private int totalBeds;

    @Column(name = "occupiedbeds", nullable = false)
    private int occupiedBeds;

    @Column(name = "extensionnumber", nullable = false)
    private int extensionNumber;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdmissionJpaEntity> admissions;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DischargeJpaEntity> dischargeInfos;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdmissionRequestJpaEntity> admissionRequests;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomJpaEntity> rooms;
}

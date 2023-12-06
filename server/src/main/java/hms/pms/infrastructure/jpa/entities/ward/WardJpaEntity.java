package hms.pms.infrastructure.jpa.entities.ward;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ward")
public class WardJpaEntity {

    @Id
    @GeneratedValue
    private UUID wardId;

    @Column(nullable = false)
    private String wardName;

    @Column
    private UUID chargeNurseId;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int totalBeds;

    @Column(nullable = false)
    private int occupiedBeds;

    @Column(nullable = false)
    private int extensionNumber;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdmissionJpaEntity> admissions;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DischargeJpaEntity> dischargeInformation;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdmissionRequestJpaEntity> admissionRequests;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomJpaEntity> rooms;
}

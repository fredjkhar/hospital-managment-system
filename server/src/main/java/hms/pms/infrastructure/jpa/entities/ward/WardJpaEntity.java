package hms.pms.infrastructure.jpa.entities.ward;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ward")
public class WardJpaEntity {

    @Id
    @GeneratedValue
    @Column(name = "ward_id")
    private UUID wardId;

    @Column(name = "ward_name", nullable = false)
    private String wardName;

    @Column(name = "charge_nurse_id")
    private UUID chargeNurseId;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "total_beds", nullable = false)
    private int totalBeds;

    @Column(name = "occupied_beds", nullable = false)
    private int occupiedBeds;

    @Column(name = "extension_number", nullable = false)
    private int extensionNumber;

    @Column(name = "status", nullable = false)
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

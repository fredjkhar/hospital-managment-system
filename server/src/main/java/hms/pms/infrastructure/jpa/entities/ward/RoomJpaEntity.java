package hms.pms.infrastructure.jpa.entities.ward;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "room")
public class RoomJpaEntity {

    @Id
    @GeneratedValue
    private UUID roomNbr;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BedJpaEntity> beds;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private int occupiedBeds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id")
    private WardJpaEntity ward;
}

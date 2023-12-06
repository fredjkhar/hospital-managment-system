package hms.pms.infrastructure.jpa.entities.ward;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "room")
public class RoomJpaEntity {

    @Id
    @GeneratedValue
    @Column(name = "room_nbr", nullable = false)
    private UUID roomNbr;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "occupied_beds", nullable = false)
    private int occupiedBeds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id")
    private WardJpaEntity ward;
}

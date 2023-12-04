package hms.pms.infrastructure.jpa.entities.ward;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "bed")
public class BedJpaEntity {

    @Id
    @GeneratedValue
    private UUID bedNbr;

    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_nbr")
    private RoomJpaEntity room;
}
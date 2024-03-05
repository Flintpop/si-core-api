package core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "evenement")
public class Evenement {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nom;

  @Column(name = "dateHeureDebut")
  private java.sql.Timestamp dateHeureDebut;

  @Column(name = "dateHeureFin")
  private java.sql.Timestamp dateHeureFin;

  private int maxParticipant;

  @ManyToOne
  @JoinColumn(name = "lieuId", referencedColumnName = "id")
  private Lieu lieu;
}

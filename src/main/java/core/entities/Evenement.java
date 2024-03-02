package core.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Evenement {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nom;
  private LocalDate dateHeureDebut;
  private LocalDate dateHeureFin;
  private Long maxParticipant;
  private Long lieuId;
  @ManyToMany
  @JoinTable(
          name = "inscription",
          joinColumns = @JoinColumn(name = "evenementId"),
          inverseJoinColumns = @JoinColumn(name = "membreId")
  )
  private List<Membre> membres = new ArrayList<>();
}

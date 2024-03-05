package core.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvenementDTO {
  private int id;
  private String nom;
  private java.sql.Timestamp dateHeureDebut;
  private java.sql.Timestamp dateHeureFin;
  private int maxParticipant;
  private int lieuId; // Vous pouvez choisir de référencer directement un LieuDTO selon vos besoins

  // Constructeurs, Getters et Setters
}

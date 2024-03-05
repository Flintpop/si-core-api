package core.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EvenementAPIDTO {
  private int id;
  private String nom;
  private java.sql.Timestamp dateHeureDebut;
  private java.sql.Timestamp dateHeureFin;

  public EvenementAPIDTO() {
  }

  public EvenementAPIDTO(int id, String nom, java.sql.Timestamp dateHeureDebut, java.sql.Timestamp dateHeureFin, int maxParticipant, LieuDTO lieu) {
    this.id = id;
    this.nom = nom;
    this.dateHeureDebut = dateHeureDebut;
    this.dateHeureFin = dateHeureFin;
  }
  // Constructeurs, Getters et Setters
}

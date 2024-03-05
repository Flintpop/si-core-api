package core.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EvenementDTO {
  private int id;
  private String nom;
  private java.sql.Timestamp dateHeureDebut;
  private java.sql.Timestamp dateHeureFin;
  private int maxParticipant;
  private LieuDTO lieu;
  private List<MembreDTO> membresInscrits = new ArrayList<>();

  public EvenementDTO() {
  }

  public EvenementDTO(int id, String nom, java.sql.Timestamp dateHeureDebut, java.sql.Timestamp dateHeureFin, int maxParticipant, LieuDTO lieu) {
    this.id = id;
    this.nom = nom;
    this.dateHeureDebut = dateHeureDebut;
    this.dateHeureFin = dateHeureFin;
    this.maxParticipant = maxParticipant;
    this.lieu = lieu;
  }
  // Constructeurs, Getters et Setters
}

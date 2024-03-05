package core.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EvenementDTO {
  private int id;
  private String titre;
  private LocalDateTime dateHeureDebut;
  private LocalDateTime dateHeureFin;
  private String description;
  private LieuDTO lieu;
  private List<MembreDTO> membresInscrits = new ArrayList<>();

  public EvenementDTO() {
  }

  // Constructeur avec tous les attributs
  public EvenementDTO(int id, String titre, LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, String description, LieuDTO lieu, List<MembreDTO> membresInscrits) {
    this.id = id;
    this.titre = titre;
    this.dateHeureDebut = dateHeureDebut;
    this.dateHeureFin = dateHeureFin;
    this.description = description;
    this.lieu = lieu;
    this.membresInscrits = membresInscrits;
  }
  // Constructeurs, Getters et Setters
}

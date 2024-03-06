package core.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EvenementAPIDTO {
  private int id;
  private String titre;
  private LocalDateTime dateHeureDebut;
  private LocalDateTime dateHeureFin;
  private String description;
  private int lieuId;

  public EvenementAPIDTO() {
  }
  public EvenementAPIDTO(int id, String titre, LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, String description, int lieuId) {
    this.id = id;
    this.titre = titre;
    this.dateHeureDebut = dateHeureDebut;
    this.dateHeureFin = dateHeureFin;
    this.description = description;
    this.lieuId = lieuId;
  }

}

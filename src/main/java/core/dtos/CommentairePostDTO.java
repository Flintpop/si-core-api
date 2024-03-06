package core.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentairePostDTO {

  // Getters et Setters
  private Integer auteurId;
  private Integer evenementId;
  private String texte;

  public CommentairePostDTO() {
  }

  public CommentairePostDTO(Integer auteurId, Integer evenementId, String texte) {
    this.auteurId = auteurId;
    this.evenementId = evenementId;
    this.texte = texte;
  }

}

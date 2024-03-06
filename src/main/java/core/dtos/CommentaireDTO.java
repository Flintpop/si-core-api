package core.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CommentaireDTO {

  // Getters et Setters
  private Integer id;
  private Integer auteurId;
  private Date dateMessage;
  private Integer evenementId;
  private String texte;

  public CommentaireDTO() {
  }

  public CommentaireDTO(Integer id, Integer auteurId, Date dateMessage, Integer evenementId, String texte) {
    this.id = id;
    this.auteurId = auteurId;
    this.dateMessage = dateMessage;
    this.evenementId = evenementId;
    this.texte = texte;
  }

}

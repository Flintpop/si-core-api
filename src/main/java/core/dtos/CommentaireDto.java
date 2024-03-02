package core.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CommentaireDto {

  // Getters et Setters
  private Integer id;
  private Integer auteurId;
  private Date dateMessage;
  private Integer evenementId;
  private String texte;

}

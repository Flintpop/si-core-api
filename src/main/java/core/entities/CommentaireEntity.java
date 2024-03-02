package core.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Setter
@Getter
@Document(collection = "commentaires")
public class CommentaireEntity {

  // Getters et Setters
  @Id
  private Integer id;

  private Integer auteurId;
  private Date dateMessage;
  private Integer evenementId;
  private String texte;

}

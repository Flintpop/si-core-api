package core.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InscriptionDTO {
  private int membreId;
  private int evenementId;
  private java.sql.Timestamp dateHeureInscription;

}

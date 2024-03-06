package core.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inscription")
@IdClass(InscriptionId.class) // Cette classe représentera la clé primaire composite
public class Inscription {
  @Id
  @ManyToOne
  @JoinColumn(name = "membreId", referencedColumnName = "id")
  private Membre membreId;

  @Id
  @ManyToOne
  @JoinColumn(name = "evenementId", referencedColumnName = "id")
  private Evenement evenementId;

  @Column(name = "dateHeureInscription")
  private java.sql.Timestamp dateHeureInscription;
}



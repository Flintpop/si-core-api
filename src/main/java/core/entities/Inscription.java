package core.entities;

import jakarta.persistence.*;
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
  private Membre membre;

  @Id
  @ManyToOne
  @JoinColumn(name = "evenementId", referencedColumnName = "id")
  private Evenement evenement;

  @Column(name = "dateHeureInscription")
  private java.sql.Timestamp dateHeureInscription;
}



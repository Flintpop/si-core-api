package core.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "membre", uniqueConstraints = {@UniqueConstraint(columnNames = {"nom", "prenom"})})
public class Membre {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nom;
  private String prenom;

  @Column(name = "dateNaissance")
  private java.sql.Date dateNaissance;

  private String adresse;
  private String email;
  private String motDePasse;
}

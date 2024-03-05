package core.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembreDTO {
  private int id;
  private String nom;
  private String prenom;
  private java.sql.Date dateNaissance;
  private String adresse;
  private String email;
  private String motDePasse;

  // Constructeurs, Getters et Setters
}

package core.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LieuDTO {
  private int id;
  private String nom;
  private String adresse;
  private int capaciteAccueil;

  // Constructeurs, Getters et Setters

  public LieuDTO() {
  }

  public LieuDTO(int id, String nom, String adresse, int capaciteAccueil) {
    this.id = id;
    this.nom = nom;
    this.adresse = adresse;
    this.capaciteAccueil = capaciteAccueil;
  }

}

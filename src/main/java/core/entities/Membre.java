package core.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Membre {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nom;
  private String prenom;
  private LocalDate dateNaissance;
  private String adresse;
  private String email;
  private String motDePasse;
  @ManyToMany(mappedBy = "membres")
  private List<Evenement> evenements; // Liste des événements associés à ce membre
}

package core.dtos;

import core.entities.Membre;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventDto {
  private Long id;
  private String nom;
  private LocalDate dateHeureDebut;
  private LocalDate dateHeureFin;
  private Long maxParticipant;
  private Long lieuId;
  private List<Membre> membres = new ArrayList<>();
}

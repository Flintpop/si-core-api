package core.dtos;

import core.entities.Member;
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
  private List<Member> members = new ArrayList<>();
}

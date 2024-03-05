package core.services.impl;

import core.dtos.EvenementAPIDTO;
import core.dtos.EvenementDTO;
import core.dtos.LieuDTO;
import core.dtos.MembreDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvenementService {

  private final RestTemplate restTemplate;

  public EvenementService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public List<EvenementDTO> getAllComingEvents() {
    String eventsUrl = "http://si-event-api:8080/events"; // URL pour récupérer tous les événements
    EvenementAPIDTO[] evenementsArray = restTemplate.getForObject(eventsUrl, EvenementAPIDTO[].class);

    if (evenementsArray == null) return List.of();

    return Arrays.stream(evenementsArray)
            .filter(e -> e.getDateHeureDebut().isAfter(LocalDateTime.now())) // Filtrer les événements futurs
            .map(this::convertToEvenementDTO) // Convertir chaque EvenementAPIDTO en EvenementDTO
            .sorted(Comparator.comparing(EvenementDTO::getDateHeureDebut)) // Trier par date de début
            .collect(Collectors.toList());
  }

  private EvenementDTO convertToEvenementDTO(EvenementAPIDTO apiDto) {
    EvenementDTO dto = new EvenementDTO();
    dto.setId(apiDto.getId());
    dto.setNom(apiDto.getNom());
    dto.setDateHeureDebut(apiDto.getDateHeureDebut());
    dto.setDateHeureFin(apiDto.getDateHeureFin());
    dto.setMaxParticipant(apiDto.getMaxParticipant());

    // Ajouter les informations sur le lieu
    LieuDTO lieu = getLieuById(apiDto.getLieuId());
    dto.setLieu(lieu);

    // Ajouter la liste des membres inscrits
    List<MembreDTO> membresInscrits = getInscriptionsByEvenementId(apiDto.getId());
    dto.setMembresInscrits(membresInscrits);

    return dto;
  }

  private LieuDTO getLieuById(Long lieuId) {
    // Implémentez cette méthode pour récupérer les informations du lieu depuis une API externe ou une source de données
    return new LieuDTO(); // Retourne un objet LieuDTO fictif pour l'exemple
  }

  private List<MembreDTO> getInscriptionsByEvenementId(Long evenementId) {
    // Implémentez cette méthode pour récupérer la liste des membres inscrits à un événement depuis une API externe ou une source de données
    return List.of(); // Retourne une liste fictive de MembreDTO pour l'exemple
  }
}

package core.services.impl;

import core.dtos.EvenementAPIDTO;
import core.dtos.EvenementDTO;
import core.dtos.LieuDTO;
import core.dtos.MembreDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvenementService {

  private final RestTemplate restTemplate;
  private final String baseUrl = "http://si-event-api:8080";

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
    dto.setTitre(apiDto.getTitre());
    dto.setDateHeureDebut(apiDto.getDateHeureDebut());
    dto.setDateHeureFin(apiDto.getDateHeureFin());

    // Ajouter les informations sur le lieu
    LieuDTO lieu = getLieuById(apiDto.getLieuId());
    if (lieu == null) {
      // Si le lieu n'existe pas, on ne peut pas créer l'événement, donc faire un traitement d'erreur
      return null; // Retourne null si le lieu n'existe pas
    }
    dto.setLieu(lieu);

    // Ajouter la liste des membres inscrits
    List<MembreDTO> membresInscrits = getInscriptionsByEvenementId(apiDto.getId());
    if (membresInscrits.isEmpty()) {
      // Si aucun membre n'est inscrit, on ne peut pas créer l'événement, donc faire un traitement d'erreur
      return null; // Retourne null si aucun membre n'est inscrit
    }
    dto.setMembresInscrits(membresInscrits);

    return dto;
  }

  private LieuDTO getLieuById(int lieuId) {
    String lieuUrl = "http://si-lieu-api:8080/lieux/" + lieuId; // URL pour récupérer les informations d'un lieu
    return restTemplate.getForObject(lieuUrl, LieuDTO.class);
  }

  public ResponseEntity<String> forwardRequest(String url, HttpMethod method, String rawRequestBody) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
    HttpEntity<String> requestEntity = rawRequestBody != null ? new HttpEntity<>(rawRequestBody, headers) : new HttpEntity<>(headers);

    try {
      return restTemplate.exchange(baseUrl + url, method, requestEntity, String.class);
    } catch (HttpClientErrorException | HttpServerErrorException ex) {
      // Capturer et renvoyer les réponses d'erreur de l'API distante
      return ResponseEntity.status(ex.getStatusCode()).headers(headers).body(ex.getResponseBodyAsString());
    } catch (Exception e) {
      // Pour les autres exceptions, renvoyer un message d'erreur avec les headers
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(e.getMessage());
    }
  }

  private List<MembreDTO> getInscriptionsByEvenementId(int evenementId) {
    String evenementUrl = "http://si-event-api:8080/events/" + evenementId + "/membres"; // URL pour récupérer les membres inscrits à un événement
    MembreDTO[] membresArray = restTemplate.getForObject(evenementUrl, MembreDTO[].class);
    if (membresArray == null) return List.of();
    return Arrays.asList(membresArray);
  }
}

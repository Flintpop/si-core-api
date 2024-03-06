package core.services.impl;

import core.dtos.CommentaireDTO;
import core.dtos.CommentairePostDTO;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Service
public class CommentaireService {

  private final RestTemplate restTemplate;
  private final String baseUrl = "http://commentaire-api:8080/commentaire";
//  private final String baseUrl = "http://localhost:8081/commentaire";

  public CommentaireService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ResponseEntity<List<CommentaireDTO>> getAllCommentaires() {
    CommentaireDTO[] commentairesArray = restTemplate.getForObject(baseUrl, CommentaireDTO[].class);
    if (commentairesArray != null) {
      return ResponseEntity.ok(Arrays.asList(commentairesArray));
    } else {
      return ResponseEntity.noContent().build();
    }
  }

  public ResponseEntity<List<CommentaireDTO>> getAllCommentairesParEvenementId(int evenementId) {
    String url = this.baseUrl + "/evenement/" + evenementId;
    CommentaireDTO[] commentairesArray = restTemplate.getForObject(url, CommentaireDTO[].class);
    if (commentairesArray != null) {
      return ResponseEntity.ok(Arrays.asList(commentairesArray));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  public ResponseEntity<String> forwardRequest(String rawRequestBody) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

    HttpEntity<String> requestEntity = new HttpEntity<>(rawRequestBody, headers);
    try {
      return restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity, String.class);
    } catch (HttpClientErrorException | HttpServerErrorException ex) {
      // Ici, on ajoute également les headers à la réponse d'erreur
      return ResponseEntity.status(ex.getStatusCode()).headers(headers).body(ex.getResponseBodyAsString());
    } catch (Exception e) {
      // Ici, pour les autres exceptions, on ajoute aussi les headers
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(e.getMessage());
    }
  }

  public ResponseEntity<CommentaireDTO> getCommentaireById(int commentaireId) {
    String url = this.baseUrl + "/" + commentaireId;
    try {
      CommentaireDTO commentaire = restTemplate.getForObject(url, CommentaireDTO.class);
      return ResponseEntity.ok(commentaire);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  public ResponseEntity<CommentaireDTO> updateCommentaire(int commentaireId, CommentaireDTO commentaire) {
    String url = this.baseUrl + "/" + commentaireId;
    HttpEntity<CommentaireDTO> request = new HttpEntity<>(commentaire);
    try {
      restTemplate.put(url, request);
      return ResponseEntity.ok(commentaire);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  public ResponseEntity<Void> deleteCommentaire(int commentaireId) {
    String url = this.baseUrl + "/" + commentaireId;
    try {
      restTemplate.delete(url);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}

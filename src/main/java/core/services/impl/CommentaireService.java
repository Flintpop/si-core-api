package core.services.impl;

import core.dtos.CommentaireDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class CommentaireService {

  private final RestTemplate restTemplate;
  private final String baseUrl = "http://commentaire-api:8080/commentaire";

  public CommentaireService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public List<CommentaireDTO> getAllCommentaires() {
    CommentaireDTO[] commentairesArray = restTemplate.getForObject(baseUrl, CommentaireDTO[].class);
    return commentairesArray != null ? Arrays.asList(commentairesArray) : List.of();
  }

  public List<CommentaireDTO> getAllCommentairesParEvenementId(int evenementId) {
    String url = baseUrl + "/evenement/" + evenementId;
    CommentaireDTO[] commentairesArray = restTemplate.getForObject(url, CommentaireDTO[].class);
    return commentairesArray != null ? Arrays.asList(commentairesArray) : List.of();
  }

  public CommentaireDTO addCommentaire(CommentaireDTO commentaire) {
    HttpEntity<CommentaireDTO> request = new HttpEntity<>(commentaire);
    return restTemplate.postForObject(baseUrl, request, CommentaireDTO.class);
  }

  public CommentaireDTO getCommentaireById(int commentaireId) {
    String url = baseUrl + "/" + commentaireId;
    return restTemplate.getForObject(url, CommentaireDTO.class);
  }

  public CommentaireDTO updateCommentaire(int commentaireId, CommentaireDTO commentaire) {
    String url = baseUrl + "/" + commentaireId;
    HttpEntity<CommentaireDTO> request = new HttpEntity<>(commentaire);
    ResponseEntity<CommentaireDTO> response = restTemplate.exchange(url, HttpMethod.PUT, request, CommentaireDTO.class);
    return response.getBody();
  }

  public void deleteCommentaire(int commentaireId) {
    String url = baseUrl + "/" + commentaireId;
    restTemplate.delete(url);
  }
}

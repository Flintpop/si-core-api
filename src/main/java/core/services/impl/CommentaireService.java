package core.services.impl;

import core.dtos.CommentaireDTO;
import org.springframework.http.HttpEntity;
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

  public ResponseEntity<CommentaireDTO> addCommentaire(CommentaireDTO commentaire) {
    HttpEntity<CommentaireDTO> request = new HttpEntity<>(commentaire);
    return restTemplate.postForEntity(baseUrl, request, CommentaireDTO.class);
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

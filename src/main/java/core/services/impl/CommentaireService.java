package core.services.impl;

import core.dtos.CommentaireDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class CommentaireService {

  private final RestTemplate restTemplate;

  public CommentaireService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public List<CommentaireDTO> getAllCommentaires() {
    String url = "http://localhost:8081/commentaire";
    CommentaireDTO[] commentairesArray = restTemplate.getForObject(url, CommentaireDTO[].class);
    return commentairesArray != null ? Arrays.asList(commentairesArray) : List.of();
  }

  public List<CommentaireDTO> getAllCommentairesParEvenementId(int evenementId) {
    String url = "http://localhost:8081/commentaire/evenement/" + evenementId;
    CommentaireDTO[] commentairesArray = restTemplate.getForObject(url, CommentaireDTO[].class);
    return commentairesArray != null ? Arrays.asList(commentairesArray) : List.of();
  }
}

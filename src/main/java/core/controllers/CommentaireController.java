package core.controllers;

import core.services.impl.CommentaireService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {

  private final CommentaireService commentaireService;

  public CommentaireController(CommentaireService commentaireService) {
    this.commentaireService = commentaireService;
  }

  @GetMapping
  public ResponseEntity<String> getAllCommentaires() {
    return commentaireService.forwardRequest("", HttpMethod.GET, null);
  }

  @GetMapping("/evenement/{evenementId}")
  public ResponseEntity<String> getCommentairesParEvenementId(@PathVariable int evenementId) {
    return commentaireService.forwardRequest("/evenement/" + evenementId, HttpMethod.GET, null);
  }

  @PostMapping
  public ResponseEntity<String> addCommentaire(HttpServletRequest request) throws IOException {
    String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    return commentaireService.forwardRequest("", HttpMethod.POST, requestBody);
  }

  @GetMapping("/{commentaireId}")
  public ResponseEntity<String> getCommentaireById(@PathVariable int commentaireId) {
    return commentaireService.forwardRequest("/" + commentaireId, HttpMethod.GET, null);
  }

  @PutMapping("/{commentaireId}")
  public ResponseEntity<String> updateCommentaire(@PathVariable int commentaireId, HttpServletRequest request) throws IOException {
    String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    return commentaireService.forwardRequest("/" + commentaireId, HttpMethod.PUT, requestBody);
  }

  @DeleteMapping("/{commentaireId}")
  public ResponseEntity<String> deleteCommentaire(@PathVariable int commentaireId) {
    return commentaireService.forwardRequest("/" + commentaireId, HttpMethod.DELETE, null);
  }
}

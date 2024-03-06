package core.controllers;

import core.dtos.CommentaireDTO;
import core.services.impl.CommentaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/commentaire")
public class CommentaireController {

  private final CommentaireService commentaireService;

  public CommentaireController(CommentaireService commentaireService) {
    this.commentaireService = commentaireService;
  }

  @GetMapping
  public ResponseEntity<?> getAllCommentaires() {
    return commentaireService.forwardGetRequest("", CommentaireDTO[].class);
  }

  @GetMapping("/evenement/{evenementId}")
  public ResponseEntity<?> getCommentairesParEvenementId(@PathVariable int evenementId) {
    return commentaireService.forwardGetRequest("/evenement/" + evenementId, CommentaireDTO[].class);
  }

  @PostMapping
  public ResponseEntity<?> addCommentaire(HttpServletRequest request) throws IOException {
    String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    return commentaireService.forwardPostRequest("", requestBody, String.class);
  }

  @GetMapping("/{commentaireId}")
  public ResponseEntity<?> getCommentaireById(@PathVariable int commentaireId) {
    return commentaireService.forwardGetRequest("/" + commentaireId, CommentaireDTO.class);
  }

  @PutMapping("/{commentaireId}")
  public ResponseEntity<?> updateCommentaire(@PathVariable int commentaireId, @RequestBody CommentaireDTO commentaire) {
    return commentaireService.forwardPutRequest("/" + commentaireId, commentaire, CommentaireDTO.class);
  }

  @DeleteMapping("/{commentaireId}")
  public ResponseEntity<?> deleteCommentaire(@PathVariable int commentaireId) {
    return commentaireService.forwardDeleteRequest("/" + commentaireId);
  }
}

package core.controllers;

import core.dtos.CommentaireDTO;
import core.services.impl.CommentaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {

  private final CommentaireService commentaireService;

  public CommentaireController(CommentaireService commentaireService) {
    this.commentaireService = commentaireService;
  }

  @GetMapping
  public ResponseEntity<List<CommentaireDTO>> getAllCommentaires() {
    return commentaireService.getAllCommentaires();
  }

  @GetMapping("/evenement/{evenementId}")
  public ResponseEntity<List<CommentaireDTO>> getCommentairesParEvenementId(@PathVariable int evenementId) {
    return commentaireService.getAllCommentairesParEvenementId(evenementId);
  }

  @PostMapping
  public ResponseEntity<CommentaireDTO> addCommentaire(@RequestBody CommentaireDTO commentaire) {
    return commentaireService.addCommentaire(commentaire);
  }

  @GetMapping("/{commentaireId}")
  public ResponseEntity<CommentaireDTO> getCommentaireById(@PathVariable int commentaireId) {
    return commentaireService.getCommentaireById(commentaireId);
  }

  @PutMapping("/{commentaireId}")
  public ResponseEntity<CommentaireDTO> updateCommentaire(@PathVariable int commentaireId, @RequestBody CommentaireDTO commentaire) {
    return commentaireService.updateCommentaire(commentaireId, commentaire);
  }

  @DeleteMapping("/{commentaireId}")
  public ResponseEntity<Void> deleteCommentaire(@PathVariable int commentaireId) {
    return commentaireService.deleteCommentaire(commentaireId);
  }
}

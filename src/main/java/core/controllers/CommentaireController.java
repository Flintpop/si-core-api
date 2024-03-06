package core.controllers;

import core.dtos.CommentaireDTO;
import core.services.impl.CommentaireService;
import org.springframework.http.HttpStatus;
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
  public List<CommentaireDTO> getAllCommentaires() {
    return commentaireService.getAllCommentaires();
  }

  @GetMapping("/evenement/{evenementId}")
  public List<CommentaireDTO> getCommentairesParEvenementId(@PathVariable int evenementId) {
    return commentaireService.getAllCommentairesParEvenementId(evenementId);
  }

  @PostMapping
  public ResponseEntity<CommentaireDTO> addCommentaire(@RequestBody CommentaireDTO commentaire) {
    CommentaireDTO nouveauCommentaire = commentaireService.addCommentaire(commentaire);
    return new ResponseEntity<>(nouveauCommentaire, HttpStatus.CREATED);
  }

  @GetMapping("/{commentaireId}")
  public ResponseEntity<CommentaireDTO> getCommentaireById(@PathVariable int commentaireId) {
    CommentaireDTO commentaire = commentaireService.getCommentaireById(commentaireId);
    if (commentaire != null) {
      return ResponseEntity.ok(commentaire);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("/{commentaireId}")
  public ResponseEntity<CommentaireDTO> updateCommentaire(@PathVariable int commentaireId, @RequestBody CommentaireDTO commentaire) {
    CommentaireDTO commentaireMisAJour = commentaireService.updateCommentaire(commentaireId, commentaire);
    if (commentaireMisAJour != null) {
      return ResponseEntity.ok(commentaireMisAJour);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{commentaireId}")
  public ResponseEntity<Void> deleteCommentaire(@PathVariable int commentaireId) {
    commentaireService.deleteCommentaire(commentaireId);
    return ResponseEntity.ok().build();
  }
}

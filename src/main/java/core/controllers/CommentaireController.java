package core.controllers;

import core.dtos.CommentaireDTO;
import core.services.impl.CommentaireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CommentaireController {

  private final CommentaireService commentaireService;

  public CommentaireController(CommentaireService commentaireService) {
    this.commentaireService = commentaireService;
  }

  @GetMapping("/commentaires")
  public List<CommentaireDTO> getAllCommentaires() {
    return commentaireService.getAllCommentaires();
  }

  @GetMapping("/commentaires/evenement/{evenementId}")
  public List<CommentaireDTO> getAllCommentairesParEvenementId(@PathVariable Integer evenementId) {
    return commentaireService.getAllCommentairesParEvenementId(evenementId);
  }
}

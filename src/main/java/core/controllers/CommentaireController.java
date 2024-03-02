package core.controllers;

import core.dtos.CommentaireDto;
import core.services.CommentaireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CommentaireController {

  private final CommentaireService commentaireService;

  public CommentaireController(CommentaireService commentaireService) {
    this.commentaireService = commentaireService;
  }

  @GetMapping("/commentaires")
  public List<CommentaireDto> getAllCommentaires() {
    return commentaireService.getAllCommentaires();
  }
}

package core.controllers;

import core.dtos.EvenementDTO;
import core.services.impl.EvenementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EvenementController {
  private final EvenementService evenementService;

  public EvenementController(EvenementService evenementService) {
    this.evenementService = evenementService;
  }

  @GetMapping("/evenementsAVenir")
  public List<EvenementDTO> getEvenementsAVenir() {
    return evenementService.getAllComingEvents();
  }
}

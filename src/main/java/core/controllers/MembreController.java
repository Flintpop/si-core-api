package core.controllers;

import core.services.impl.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membres")
public class MembreController {

  private final MembreService membreService;

  @Autowired
  public MembreController(MembreService membreService) {
    this.membreService = membreService;
  }

  @GetMapping
  public ResponseEntity<String> listerMembres() {
    return membreService.forwardRequest("", HttpMethod.GET, null);
  }

  @PostMapping
  public ResponseEntity<String> creerMembre(@RequestBody String membreJson) {
    return membreService.forwardRequest("", HttpMethod.POST, membreJson);
  }

  @GetMapping("/{membreId}")
  public ResponseEntity<String> recupererMembre(@PathVariable("membreId") String membreId) {
    return membreService.forwardRequest("/" + membreId, HttpMethod.GET, null);
  }

  @PutMapping("/{membreId}")
  public ResponseEntity<String> mettreAJourMembre(@PathVariable("membreId") String membreId, @RequestBody String membreJson) {
    return membreService.forwardRequest("/" + membreId, HttpMethod.PUT, membreJson);
  }

  @DeleteMapping("/{membreId}")
  public ResponseEntity<String> supprimerMembre(@PathVariable("membreId") String membreId) {
    return membreService.forwardRequest("/" + membreId, HttpMethod.DELETE, null);
  }
}

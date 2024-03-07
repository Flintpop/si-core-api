package core.controllers;

import core.services.impl.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:8080"})
@RestController
public class EvenementController {

  private final EvenementService evenementService;

  @Autowired
  public EvenementController(EvenementService evenementService) {
    this.evenementService = evenementService;
  }

  @GetMapping("/events")
  public ResponseEntity<String> listerEvenements() {
    return evenementService.forwardRequest("/events", HttpMethod.GET, null);
  }

  @PostMapping("/events")
  public ResponseEntity<String> creerEvenement(@RequestBody String evenementJson) {
    return evenementService.forwardRequest("/events", HttpMethod.POST, evenementJson);
  }

  @GetMapping("/events/{eventId}")
  public ResponseEntity<String> recupererEvenement(@PathVariable("eventId") String eventId) {
    return evenementService.forwardRequest("/events/" + eventId, HttpMethod.GET, null);
  }

  @PutMapping("/events/{eventId}")
  public ResponseEntity<String> mettreAJourEvenement(@PathVariable("eventId") String eventId, @RequestBody String evenementJson) {
    return evenementService.forwardRequest("/events/" + eventId, HttpMethod.PUT, evenementJson);
  }

  @DeleteMapping("/events/{eventId}")
  public ResponseEntity<String> supprimerEvenement(@PathVariable("eventId") String eventId) {
    return evenementService.forwardRequest("/events/" + eventId, HttpMethod.DELETE, null);
  }

  @GetMapping("/events/{eventId}/membres")
  public ResponseEntity<String> listerMembresInscrits(@PathVariable("eventId") String eventId) {
    return evenementService.forwardRequest("/events/" + eventId + "/membres", HttpMethod.GET, null);
  }

  @PutMapping("/events/{eventId}/membres")
  public ResponseEntity<String> inscrireMembre(@PathVariable("eventId") String eventId, @RequestBody String membreJson) {
    return evenementService.forwardRequest("/events/" + eventId + "/membres", HttpMethod.PUT, membreJson);
  }

  @DeleteMapping("/events/{eventId}/membres/{membreId}")
  public ResponseEntity<String> desinscrireMembre(@PathVariable("eventId") String eventId, @PathVariable("membreId") String membreId) {
    return evenementService.forwardRequest("/events/" + eventId + "/membres/" + membreId, HttpMethod.DELETE, null);
  }

  @PutMapping("/events/{eventId}/location")
  public ResponseEntity<String> associerLieu(@PathVariable("eventId") String eventId, @RequestBody String locationJson) {
    return evenementService.forwardRequest("/events/" + eventId + "/location", HttpMethod.PUT, locationJson);
  }

  @DeleteMapping("/events/{eventId}/location")
  public ResponseEntity<String> dissocierLieu(@PathVariable("eventId") String eventId) {
    return evenementService.forwardRequest("/events/" + eventId + "/location", HttpMethod.DELETE, null);
  }
}

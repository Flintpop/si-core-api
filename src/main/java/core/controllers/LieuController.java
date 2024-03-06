package core.controllers;

import core.services.impl.LieuService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/lieux")
public class LieuController {

  private final LieuService lieuService;

  public LieuController(LieuService lieuService) {
    this.lieuService = lieuService;
  }

  @GetMapping
  public ResponseEntity<String> getAllLieux() {
    return lieuService.forwardRequest("", HttpMethod.GET, null);
  }

  @PostMapping
  public ResponseEntity<String> createLieu(HttpServletRequest request) throws IOException {
    String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    return lieuService.forwardRequest("", HttpMethod.POST, requestBody);
  }

  @GetMapping("/{lieuId}")
  public ResponseEntity<String> getLieuById(@PathVariable String lieuId) {
    return lieuService.forwardRequest("/" + lieuId, HttpMethod.GET, null);
  }

  @PutMapping("/{lieuId}")
  public ResponseEntity<String> updateLieu(@PathVariable String lieuId, HttpServletRequest request) throws IOException {
    String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    return lieuService.forwardRequest("/" + lieuId, HttpMethod.PUT, requestBody);
  }

  @DeleteMapping("/{lieuId}")
  public ResponseEntity<String> deleteLieu(@PathVariable String lieuId) {
    return lieuService.forwardRequest("/" + lieuId, HttpMethod.DELETE, null);
  }
}

package core.services.impl;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Service
public class MembreService {

  private final RestTemplate restTemplate;
  private final String baseUrl = "http://membre-api:8080/membres";

  public MembreService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }
  public ResponseEntity<String> forwardRequest(String url, HttpMethod method, String rawRequestBody) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
    HttpEntity<String> requestEntity = rawRequestBody != null ? new HttpEntity<>(rawRequestBody, headers) : new HttpEntity<>(headers);

    try {
      return restTemplate.exchange(baseUrl + url, method, requestEntity, String.class);
    } catch (HttpClientErrorException | HttpServerErrorException ex) {
      // Capturer et renvoyer les réponses d'erreur de l'API distante
      return ResponseEntity.status(ex.getStatusCode()).headers(headers).body(ex.getResponseBodyAsString());
    } catch (Exception e) {
      // Pour les autres exceptions, renvoyer un message d'erreur avec les headers
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(e.getMessage());
    }
  }
}

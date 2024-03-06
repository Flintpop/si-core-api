package core.services.impl;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Service
public class CommentaireService {

  private final RestTemplate restTemplate;
  private final String baseUrl = "http://commentaire-api:8080/commentaire";

  public CommentaireService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public <T> ResponseEntity<T> forwardGetRequest(String url, Class<T> responseType) {
    try {
      T response = restTemplate.getForObject(baseUrl + url, responseType);
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<String> forwardPostRequest(String url, String rawRequestBody, Class<String> responseType) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

    HttpEntity<String> requestEntity = new HttpEntity<>(rawRequestBody, headers);
    return exchangeRequest(url, HttpMethod.POST, requestEntity, responseType);
  }

  public <T> ResponseEntity<T> forwardPutRequest(String url, T body, Class<T> responseType) {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<T> requestEntity = new HttpEntity<>(body, headers);
    return exchangeRequest(url, HttpMethod.PUT, requestEntity, responseType);
  }

  public ResponseEntity<Void> forwardDeleteRequest(String url) {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
    return exchangeRequest(url, HttpMethod.DELETE, requestEntity, Void.class);
  }

  private <T> ResponseEntity<T> exchangeRequest(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType) {
    try {
      return restTemplate.exchange(baseUrl + url, method, requestEntity, responseType);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}

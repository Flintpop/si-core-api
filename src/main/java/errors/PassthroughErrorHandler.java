package errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class PassthroughErrorHandler implements ResponseErrorHandler {

  private static final Logger log = LoggerFactory.getLogger(PassthroughErrorHandler.class);

  private final ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();

  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    // Utilisez l'implémentation par défaut pour déterminer si la réponse a une erreur
//    return errorHandler.hasError(response);
    return errorHandler.hasError(response);
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    // Ici, au lieu de lancer une exception, nous allons logger l'erreur
    String body = new BufferedReader(new InputStreamReader(response.getBody()))
            .lines().collect(Collectors.joining("\n"));
    log.error("Response error: {} {}", response.getStatusCode(), body);
    throw new HttpClientErrorException(response.getStatusCode(), response.getStatusText(), response.getHeaders(), body.getBytes(), null);

    // Notez que cette implémentation spécifique ne relance pas d'exception,
    // vous pouvez choisir de le faire selon le cas d'usage
  }
}

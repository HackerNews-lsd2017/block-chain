package api;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class AppConfig {

    
    public RestTemplate getRestTemplateWithTimeout(Integer timeOutMs) {
        return new RestTemplate(clientHttpRequestFactory(timeOutMs));
    }

    private ClientHttpRequestFactory clientHttpRequestFactory(Integer timeOutMs) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(timeOutMs);
        factory.setConnectTimeout(timeOutMs);
        return factory;
    }
}


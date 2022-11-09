package org.fes.service.implementation;

import org.fes.bean.dto.CityDto;
import org.fes.service.interfaces.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {

    public static final Duration WEBCLIENT_TIMEOUT = Duration.ofSeconds(30);

    private final WebClient client;

    @Value("${spring.bosa.cities-endpoint}")
    private String serviceEndpoint;

    @Autowired
    public CityServiceImpl(WebClient client) {
        this.client = client;
    }

    @Override
    public Optional<List<CityDto>> getCities() {
        return client
                .method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder
                        .path(serviceEndpoint)
                        .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CityDto>>() {})
                .blockOptional(WEBCLIENT_TIMEOUT);
    }
}

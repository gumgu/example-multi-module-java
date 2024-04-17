package hello.clients.config;

import hello.clients.client.weather.WeatherApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherApiClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WeatherApiClient weatherApiClient(RestTemplate restTemplate) {
        return new WeatherApiClient(restTemplate);
    }
}
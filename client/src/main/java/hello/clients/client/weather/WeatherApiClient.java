package hello.clients.client.weather;

import hello.clients.client.weather.dto.WeatherApiRequestDto;
import hello.clients.client.weather.dto.WeatherApiResponseDto;
import hello.clients.support.response.ClientResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
public class WeatherApiClient {
    private static final String WEATHER_API_ENDPOINT = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
    private static final String SERVICE_KEY = "G3gZsbEVdAXophwOPJpP/zgwJ37NsxFpWwJRfEwDcGNCy/UVqSft4JJZNkEKlPHiel1RT0XF8cEJuOBj3kQuhQ==";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private final RestTemplate restTemplate;

    /**
     * api가 호출된 시점부터 대략 하루치의 데이터 정보를 저장합니다.
     */
    public ClientResponse<WeatherApiResponseDto> getWeatherInfo() {
        String today = LocalDate.now().format(formatter);

        // request URI 생성
        String uri = WEATHER_API_ENDPOINT + "?" + WeatherApiRequestDto.builder()
                .serviceKey(SERVICE_KEY)
                .nx(62)
                .ny(130)
                .baseDate(today)
                .baseTime("0500")
                .dataType("JSON")
                .numOfRows(300)
                .build()
                .toQueryString();
        WeatherApiResponseDto forObject = restTemplate.getForObject(uri, WeatherApiResponseDto.class);

        try {
            return ClientResponse.ok(restTemplate.getForObject(uri, WeatherApiResponseDto.class));
        } catch (RestClientException e) {
            e.printStackTrace();
            return ClientResponse.failed(e);
        } catch (Exception e) {
            e.printStackTrace();
            return ClientResponse.failed(e);
        }
    }
}

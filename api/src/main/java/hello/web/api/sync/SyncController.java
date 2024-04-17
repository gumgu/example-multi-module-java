package hello.web.api.sync;

import hello.clients.client.weather.WeatherApiClient;
import hello.clients.client.weather.dto.WeatherApiResponseDto;
import hello.clients.support.response.ClientResponse;
import hello.clients.support.response.ResultType;
import hello.core.domain.WeatherForecast;
import hello.core.domain.WeatherService;
import hello.web.support.error.ApiSyncFailedException;
import hello.web.support.error.ErrorType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SyncController {

    private final WeatherApiClient weatherApiClient;
    private final WeatherService weatherService;

    @PostMapping("/loadWeather")
    public void loadWeather() {
        ClientResponse<WeatherApiResponseDto> weatherInfoList = weatherApiClient.getWeatherInfo();

        // ClientResponse에서 연동을 실패한 경우 예외 발생
        if (weatherInfoList.getResult() != ResultType.SUCCESS) {
            throw new ApiSyncFailedException(ErrorType.API_SYNC_ERROR);
        }

        List<WeatherApiResponseDto.Response.Body.Items.Item> items = weatherInfoList.getData().getItems();

        for (WeatherApiResponseDto.Response.Body.Items.Item item : items) {
            WeatherForecast weatherForecast = new WeatherForecast(
                    item.getBaseDate(),
                    item.getBaseTime(),
                    item.getCategory(),
                    item.getFcstDate(),
                    item.getFcstTime(),
                    item.getFcstValue(),
                    item.getNx(),
                    item.getNy()
            );
            weatherService.saveWeatherForecast(weatherForecast);
        }
    }
}

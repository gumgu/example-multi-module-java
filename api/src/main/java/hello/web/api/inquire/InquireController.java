package hello.web.api.inquire;

import hello.core.domain.WeatherForecast;
import hello.core.domain.WeatherService;
import hello.web.api.inquire.dto.InquireResponseDto;
import hello.web.support.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class InquireController {

    private final WeatherService weatherService;

    @GetMapping("/getWeather")
    public ResponseEntity<ApiResponse<?>> getWeather() {
        List<InquireResponseDto> results = new ArrayList<>();

        List<WeatherForecast> forecasts = weatherService.getWeatherForecasts();

        if(forecasts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        for(WeatherForecast forecast : forecasts) {
            results.add(new InquireResponseDto(forecast.getCategory(), forecast.getFcstValue()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(results));
    }
}

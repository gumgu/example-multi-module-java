package hello.core.domain;

import hello.core.repository.WeatherForecastRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherForecastRepository weatherForecastRepository;

    @Transactional
    public void saveWeatherForecast(WeatherForecast weatherForecast) {
        weatherForecastRepository.save(weatherForecast);
    }

    public List<WeatherForecast> getWeatherForecasts() {
        LocalDateTime now = LocalDateTime.now();
        String fcstDate = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String fcstTime = now.format(DateTimeFormatter.ofPattern("HH00"));

        return weatherForecastRepository.findByFcstDateAndFcstTime(fcstDate, fcstTime);
    }
}

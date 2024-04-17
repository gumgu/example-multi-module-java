package hello.core.repository;

import hello.core.domain.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {

    List<WeatherForecast> findByFcstDateAndFcstTime(String fcstDate, String fcstTime);
}

package hello.core.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Entity
@Getter
@AllArgsConstructor
public class WeatherForecast implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String baseDate;

    @Column(nullable = false)
    private String baseTime;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String fcstDate;

    @Column(nullable = false)
    private String fcstTime;

    @Column(nullable = false)
    private String fcstValue;

    @Column(nullable = false)
    private int nx;

    @Column(nullable = false)
    private int ny;

    public WeatherForecast(String baseDate, String baseTime, String category, String fcstDate, String fcstTime, String fcstValue, int nx, int ny) {
        this.baseDate = baseDate;
        this.baseTime = baseTime;
        this.category = category;
        this.fcstDate = fcstDate;
        this.fcstTime = fcstTime;
        this.fcstValue = fcstValue;
        this.nx = nx;
        this.ny = ny;
    }

    public WeatherForecast() {
    }

}

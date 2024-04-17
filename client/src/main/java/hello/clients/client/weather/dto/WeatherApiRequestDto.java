package hello.clients.client.weather.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WeatherApiRequestDto {
    private String serviceKey;
    private int nx;
    private int ny;
    private String baseDate;
    private String baseTime;
    private String dataType;
    private int numOfRows;

    public String toQueryString() {
        return "ServiceKey=" + this.serviceKey +
                "&nx=" + this.nx +
                "&ny=" + this.ny +
                "&base_date=" + this.baseDate +
                "&base_time=" + this.baseTime +
                "&dataType=" + this.dataType +
                "&numOfRows=" + this.numOfRows;
    }

}

package hello.web.api.inquire.dto;

import lombok.Data;

@Data
public class InquireResponseDto {
    private String category;
    private String fcstValue;

    public InquireResponseDto(String category, String fcstValue) {
        this.category = category;
        this.fcstValue = fcstValue;
    }
}

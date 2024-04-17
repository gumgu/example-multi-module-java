package hello.clients.client.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
public class WeatherApiResponseDto {

    private Response response;

    @Data
    public static class Response {

        private Header header;
        private Body body;

        @Data
        public static class Header {
            private String resultCode;
            private String resultMsg;

        }

        @Data
        public static class Body {
            private String dataType;
            private Items items;

            @Data
            public static class Items {
                @JsonProperty("item")
                private List<Item> itemList;

                @Data
                public static class Item {
                    private String baseDate;
                    private String baseTime;
                    private String category;
                    private String fcstDate;
                    private String fcstTime;
                    private String fcstValue;
                    private int nx;
                    private int ny;

                }
            }
        }
    }

    public List<Response.Body.Items.Item> getItems() {
        return this.getResponse().getBody().getItems().getItemList();
    }
}

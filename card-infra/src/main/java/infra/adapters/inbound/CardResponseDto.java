package infra.adapters.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CardResponseDto(@JsonProperty("card_id") String cardId, @JsonProperty("card_name") String cardName) {

}

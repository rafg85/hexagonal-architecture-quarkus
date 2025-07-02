package infra.adapters.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateCardRequestDto(@JsonProperty("card_name") String cardName) {

}

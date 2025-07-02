package infra.adapters.inbound;

import java.util.List;

import core.domain.model.Card;
import core.ports.inbound.CardServicePort;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CardControllerAdapter {

    private CardServicePort cardServicePort;

    @Inject
    public CardControllerAdapter(CardServicePort cardServicePort) {
        this.cardServicePort = cardServicePort;
    }

    @POST
    public CardResponseDto saveCard(CreateCardRequestDto request) {
        Card card = cardServicePort.createCard(request.cardName());
        return new CardResponseDto(card.cardId().toString(), card.cardName());
    }

    @GET
    public List<CardResponseDto> getAllCards() {
        List<Card> cards = cardServicePort.getAllCards();
        return cards.stream()
                .map(card -> new CardResponseDto(card.cardId().toString(), card.cardName()))
                .toList();
    }
}

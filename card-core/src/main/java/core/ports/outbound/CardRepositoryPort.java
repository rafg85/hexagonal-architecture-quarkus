package core.ports.outbound;

import java.util.List;

import core.domain.model.Card;

public interface CardRepositoryPort {

	List<Card> findAllCards();

	Card saveCard(String cardName);

}

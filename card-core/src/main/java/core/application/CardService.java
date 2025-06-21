package core.application;

import java.util.List;

import core.domain.DomainService;
import core.domain.model.Card;
import core.ports.inbound.CardServicePort;
import core.ports.outbound.CardRepositoryPort;
import core.ports.outbound.ExternalClientPort;

@DomainService
public class CardService implements CardServicePort {

	private CardRepositoryPort cardRepositoryPort;

	private ExternalClientPort externalClientPort;

	public CardService(CardRepositoryPort cardRepositoryPort, ExternalClientPort externalClientPort) {
		this.cardRepositoryPort = cardRepositoryPort;
		this.externalClientPort = externalClientPort;
	}

	@Override
	public Card createCard(String cardName) {
		return cardRepositoryPort.saveCard(getVerifiedCardName(cardName));
	}

	@Override
	public List<Card> getAllCards() {
		return cardRepositoryPort.findAllCards();
	}

	public String getVerifiedCardName(String cardName) {
		return externalClientPort.getVerifiedCardName(cardName);
	}

}

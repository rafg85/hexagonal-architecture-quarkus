package infra.adapters.outbound;

import java.util.List;

import core.domain.model.Card;
import core.ports.outbound.CardRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CardRepositoryAdapter implements CardRepositoryPort {

    @Override
    public List<Card> findAllCards() {
        return CardEntity.<CardEntity>listAll()
                .stream()
                .map(entity -> new Card(entity.id, entity.getCardName()))
                .toList();
    }

    @Override
    @Transactional
    public Card saveCard(String cardName) {
        CardEntity entity = new CardEntity(cardName);
        entity.persistAndFlush();
        return new Card(entity.id, entity.getCardName());

    }

}

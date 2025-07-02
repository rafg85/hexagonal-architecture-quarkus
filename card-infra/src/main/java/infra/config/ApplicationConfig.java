package infra.config;

import core.application.CardService;
import core.ports.outbound.CardRepositoryPort;
import core.ports.outbound.ExternalClientPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ApplicationConfig {

    @Produces
    @ApplicationScoped
    public CardService cardService(CardRepositoryPort cardRepositoryPort,
            ExternalClientPort externalClientPort) {
        return new CardService(cardRepositoryPort, externalClientPort);
    }

}

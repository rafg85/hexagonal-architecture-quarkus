package infra.adapters.outbound;

import java.util.Optional;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import core.ports.outbound.ExternalClientPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ExternalClientAdapter implements ExternalClientPort {

    @Inject
    @RestClient
    ExternalRestClient externalRestClient;

    @Override
    public String getVerifiedCardName(String cardName) {
        try {
            ClientCardDto response = externalRestClient.getCardByName(cardName);
            return Optional.ofNullable(response)
                    .map(ClientCardDto::name)
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

}

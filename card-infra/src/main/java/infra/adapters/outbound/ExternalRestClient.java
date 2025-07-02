package infra.adapters.outbound;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@RegisterRestClient(baseUri = "https://api.scryfall.com")
public interface ExternalRestClient {

    @GET
    @Path("/cards/named")
    ClientCardDto getCardByName(@QueryParam("fuzzy") String cardName);

}

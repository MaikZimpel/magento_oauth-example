package ecs.magento.oauth;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.util.Scanner;

/**
 * Created by mzimpel on 28.08.14.
 */
public class Main {


    public static void main(String[] args) {
        final String MAGENTO_API_KEY = "2567520cbfea351e4b05513bff3f9166";
        final String MAGENTO_API_SECRET = "44cb7cbdf4a333821fd5420c7fd5ae0b";
        final String MAGENTO_REST_API_URL = "http://localhost/magento/api/rest";

        OAuthService service = new ServiceBuilder()
                .provider(MagentoThreeLeggedOAuth.class)
                .apiKey(MAGENTO_API_KEY)
                .apiSecret(MAGENTO_API_SECRET)
                .debug()
                .build();

        Token permanentToken = new Token("c653163ebf219c51c0451224efe87b55", "6a3587e0c77195c4980a54a5ce765c8a");

        /**
        Scanner in = new Scanner(System.in);
        System.out.println("Magento'srkflow");
        System.out.println();

        System.out.println("FetchingRequest Token...");
        Token requestToken = service.getRequestToken();
        System.out.println("GotRequest Token!");
        System.out.println();

        // Obtain the Authorization URL
        System.out.println("FetchingAuthorization URL...");
        String authorizationUrl = service.getAuthorizationUrl(requestToken);
        System.out.println("GotAuthorization URL!");
        System.out.println("Nownd authorize Main here:");
        System.out.println(authorizationUrl);
        System.out.println("Ande the authorization code here");
        System.out.print(">>");
        Verifier verifier = new Verifier(in.nextLine());
        System.out.println();

        // Trade the Request Token and Verfier for the Access Token
        System.out.println("TradingRequest Token for an Access Token...");
        Token accessToken = service.getAccessToken(requestToken, verifier);
        System.out.println("GotAccess Token!");
        System.out.println("(if curious it looks like this: "
                + accessToken + " )");
        System.out.println();

        Token permanentToken = new Token("c653163ebf219c51c0451224efe87b55", "6a3587e0c77195c4980a54a5ce765c8a");
        */
        // Now let's go and ask for a protected resource!
        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/products?limit=2");
        service.signRequest(permanentToken, request);
        Response response = request.send();
        System.out.println();
        System.out.println(response.getCode());
        System.out.println(response.getBody());
        System.out.println();


    }
}

import API.api;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String endpoint = "/API/drones";
        String domain = "http://dronesim.facets-labs.com";
        //String domain2 = "http://dronesim.facets-labs.com/api/dronetypes/?limit=10&offset=10";
        String token = "Token 40a9557fac747f55c11ad20c85caac1d43654911";
        String agent = "Louay";

        api myApi = new api(endpoint, domain, token, agent);

        myApi.createConnection("/API/dronetypes/");
        String response = myApi.retrieveResponse();
        System.out.println(response);
    }
}

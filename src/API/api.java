package API;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class api {
    private String endpoint;
    private String domain;
    private String token;
    private String agent;
    private HttpURLConnection connection;

    public api(String endpoint, String domain, String token, String agent) {
        this.endpoint = endpoint;
        this.domain = domain;
        this.token = token;
        this.agent = agent;
    }

    public void createConnection(String endpoint) throws IOException {
        URL url = new URL(domain + endpoint);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", token);
        connection.setRequestProperty("User-Agent", agent);
    }

    public String retrieveResponse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();
        return content.toString();
    }
    public String getDroneDynamics() throws IOException {
        createConnection("/API/dronetypes/");
        return retrieveResponse();
    }

    public JSONObject getDroneData(String droneId) throws  IOException {
        createConnection("/API/dronetypes/" + droneId);
        String response = retrieveResponse();
        return new JSONObject(response);
    }


}

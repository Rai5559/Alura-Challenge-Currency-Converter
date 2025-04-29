package org.rai5569;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateReq {

    public ExchangeRate getCurrencyRequest(String code) {
        HttpResponse<String> response = null;
        try{
            Dotenv dotenv = Dotenv.load();
            String url = "https://v6.exchangerate-api.com/v6/"+dotenv.get("API_KEY")+"/latest/"+code;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return new Gson().fromJson(response.body(), ExchangeRate.class);
    }
}
package com.curso.alura.api;

import com.curso.alura.models.LatestExchangeRateDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author Soriano
 */
public class ExchangeRateAPI {
    private static final String API_KEY = "43a001f465fe26f57da42bb9";

    public LatestExchangeRateDTO latestExhangeRate(String currency){
        String address = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s",
                API_KEY, currency);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            //System.out.println("response: \n"+json);

            return new Gson().fromJson(json, LatestExchangeRateDTO.class);
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

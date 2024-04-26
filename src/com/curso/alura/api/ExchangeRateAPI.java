package com.curso.alura.api;

import com.curso.alura.models.ConversionPairDTO;
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

            return new Gson().fromJson(json, LatestExchangeRateDTO.class);
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ConversionPairDTO getConversionRate(String currency1, String currency2){
        String address = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                API_KEY, currency1, currency2);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            return new Gson().fromJson(json, ConversionPairDTO.class);
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String conversion(double amount, String baseCurrency, String targetCurrency){
        String address = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                API_KEY, baseCurrency, targetCurrency);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new Gson();
            ConversionPairDTO dto = gson.fromJson(json, ConversionPairDTO.class);

            if(dto.result().equals("success")){
                double resultConversion = amount * dto.conversion_rate();

                String format = String.format("\nLa tasa de cambio entre '%s' y '%s' es de %.4f." +
                                "\nPor tanto, la cantidad '%s %.2f' corresponde al valor: %s %.2f",
                        dto.base_code(), dto.target_code(), dto.conversion_rate(),
                        dto.base_code(), amount, dto.target_code(), resultConversion);

                return format;
            }
            else{
                String format = String.format("""

                                        Los códigos '%s' o '%s' de monedas que ingresaste no son válidos.
                                        Intenta con otra combinación.
                                        """,
                        baseCurrency, targetCurrency);

                return format;
            }
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.curso.alura.main;

import com.curso.alura.api.ExchangeRateAPI;
import com.curso.alura.models.LatestExchangeRateDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Scanner;

/**
 * @author Soriano
 */
public class MainCurrencyConverter {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        System.out.println("Consulta la tasa de cambio de la moneda que desees.");
        System.out.println("Ingresa la moneda:");
        String currency = lectura.nextLine();

        ExchangeRateAPI api = new ExchangeRateAPI();

        LatestExchangeRateDTO dto = api.latestExhangeRate(currency);

        if(dto.result().equals("success")){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(dto);

            String format = String.format("\nTasas de cambio actualizadas de la moneda '%s':\n%s",
                    currency.toUpperCase(), jsonOutput);
            System.out.println(format);
        }
        else{
            String format = String.format("El código '%s' de moneda que ingresaste no es válido.\n" +
                            "Intenta con otro.",
                    currency);
            System.out.println(format);
        }

    }
}

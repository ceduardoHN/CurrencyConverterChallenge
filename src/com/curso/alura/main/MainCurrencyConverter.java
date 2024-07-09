package com.curso.alura.main;

import com.curso.alura.api.ExchangeRateAPI;
import com.curso.alura.models.ConversionPairDTO;
import com.curso.alura.models.LatestExchangeRateDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Scanner;

/**
 * @author Soriano
 */
public class MainCurrencyConverter {

    public static void main(String[] args) {
        Scanner entradaMenu = new Scanner(System.in);
        Scanner entradaOp3 = new Scanner(System.in);
        boolean flagOp2 = true;
        ExchangeRateAPI api = new ExchangeRateAPI();
        double amount = 0;
        String conversionResult = "";

        while(true){
            System.out.println("-----------------MENÚ PRINCIPAL CONVERTIDOR DE MONEDAS-----------------");
            System.out.println("1. Obtener tasas de cambio actualizadas de una moneda específica.");
            System.out.println("2. Obtener tasa de cambio actualizada entre dos monedas.");
            System.out.println("3. Conversiones.");
            System.out.println("4. SALIR");
            int opcionMenu = entradaMenu.nextInt();

            switch(opcionMenu) {
                case 1:
                    Scanner entradaMenuOp1 = new Scanner(System.in);

                    System.out.println("\nIngresa la moneda:");
                    String currency = entradaMenuOp1.nextLine();

                    LatestExchangeRateDTO latestExchangeRateDTO = api.latestExhangeRate(currency);

                    if(latestExchangeRateDTO.result().equals("success")){
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String jsonOutput = gson.toJson(latestExchangeRateDTO);

                        String format = String.format("\nTasas de cambio actualizadas de la moneda '%s':\n%s\n",
                                currency.toUpperCase(), jsonOutput);
                        System.out.println(format);
                    }
                    else{
                        String format = String.format("""

                                        El código '%s' de moneda que ingresaste no es válido.
                                        Intenta con otro.
                                        """,
                                currency);
                        System.out.println(format);
                    }

                    break;
                case 2:
                    Scanner entradaMenuOp2 = new Scanner(System.in);

                    System.out.println("\nIngresa la primera moneda:");
                    String currency1 = entradaMenuOp2.nextLine();

                    System.out.println("\nIngresa la segunda moneda:");
                    String currency2 = entradaMenuOp2.nextLine();

                    ConversionPairDTO conversionPairDTO = api.getConversionRate(currency1, currency2);

                    if(conversionPairDTO.result().equals("success")){
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String jsonOutput = gson.toJson(conversionPairDTO);

                        String format = String.format("\nTasa de conversion entre '%s' y '%s':\n%s\n",
                                currency1.toUpperCase(), currency2.toUpperCase(), jsonOutput);
                        System.out.println(format);
                    }
                    else{
                        String format = String.format("""

                                        Los códigos '%s' o '%s' de monedas que ingresaste no son válidos.
                                        Intenta con otra combinación.
                                        """,
                                currency1, currency2);
                        System.out.println(format);
                    }

                    break;
                case 3:
                    flagOp2 = true;
                    while(flagOp2){
                        System.out.println("\n-----------------Menú de Conversiones-----------------");
                        System.out.println("1. Dólar --> Peso Argentino");
                        System.out.println("2. Peso Argentino --> Dólar");
                        System.out.println("3. Dólar --> Real Brasileño");
                        System.out.println("4. Real Brasileño --> Dólar");
                        System.out.println("5. Dólar --> Peso Colombiano");
                        System.out.println("6. Peso Colombiano --> Dólar");
                        System.out.println("7. Dólar --> Lempira");
                        System.out.println("8. Lempira --> Dólar");
                        System.out.println("9. Conversión de otras monedas.");
                        System.out.println("10. Volver a Menú Principal");
                        int opcionConversiones = entradaMenu.nextInt();

                        switch(opcionConversiones) {
                            case 1:
                                System.out.println("\nIngresa la cantidad que quieres convertir:");
                                amount = entradaOp3.nextDouble();

                                conversionResult = api.conversion(amount, "USD", "ARS");
                                System.out.println(conversionResult);

                                break;
                            case 2:
                                System.out.println("\nIngresa la cantidad que quieres convertir:");
                                amount = entradaOp3.nextDouble();

                                conversionResult = api.conversion(amount, "ARS", "USD");
                                System.out.println(conversionResult);

                                break;
                            case 3:
                                System.out.println("\nIngresa la cantidad que quieres convertir:");
                                amount = entradaOp3.nextDouble();

                                conversionResult = api.conversion(amount, "USD", "BRL");
                                System.out.println(conversionResult);

                                break;
                            case 4:
                                System.out.println("\nIngresa la cantidad que quieres convertir:");
                                amount = entradaOp3.nextDouble();

                                conversionResult = api.conversion(amount, "BRL", "USD");
                                System.out.println(conversionResult);

                                break;
                            case 5:
                                System.out.println("\nIngresa la cantidad que quieres convertir:");
                                amount = entradaOp3.nextDouble();

                                conversionResult = api.conversion(amount, "USD", "COP");
                                System.out.println(conversionResult);

                                break;
                            case 6:
                                System.out.println("\nIngresa la cantidad que quieres convertir:");
                                amount = entradaOp3.nextDouble();

                                conversionResult = api.conversion(amount, "COP", "USD");
                                System.out.println(conversionResult);

                                break;
                            case 7:
                                System.out.println("\nIngresa la cantidad que quieres convertir:");
                                amount = entradaOp3.nextDouble();

                                conversionResult = api.conversion(amount, "USD", "HNL");
                                System.out.println(conversionResult);

                                break;
                            case 8:
                                System.out.println("\nIngresa la cantidad que quieres convertir:");
                                amount = entradaOp3.nextDouble();

                                conversionResult = api.conversion(amount, "HNL", "USD");
                                System.out.println(conversionResult);

                                break;
                            case 9:
                                Scanner entradaOp3Op9 = new Scanner(System.in);

                                System.out.println("\nIngresa la moneda base:");
                                String baseCurrency = entradaOp3Op9.nextLine();

                                System.out.println("\nIngresa la moneda a la que quieres convertir:");
                                String targetCurrency = entradaOp3Op9.nextLine();

                                System.out.println(String.format("\nIngresa la cantidad que quieres convertir de '%s' a '%s':",
                                        baseCurrency.toUpperCase(), targetCurrency.toUpperCase()));
                                amount = entradaOp3.nextDouble();

                                conversionResult = api.conversion(amount, baseCurrency, targetCurrency);
                                System.out.println(conversionResult);

                                break;
                            case 10:
                                flagOp2=false;
                                break;
                            default:
                                String format = String.format("\n¡¡La opcion '%d' no es válida!!\n", opcionConversiones);
                                System.out.println(format);
                        }

                    }

                    break;
                case 4:
                    System.out.println("¡¡Nos vemos!!\nTe esperamos de vuelta.");
                    System.exit(0);

                    break;
                default:
                    String format = String.format("\n¡¡La opcion '%d' no es valida!!\n", opcionMenu);
                    System.out.println(format);
                    break;
            }
        }

    }
}

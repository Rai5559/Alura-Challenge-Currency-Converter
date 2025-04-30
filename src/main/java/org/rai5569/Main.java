package org.rai5569;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        * Codes:
        *   ARS - Peso argentino

            BRL - Real brasileño

            COP - Peso colombiano

            USD - Dólar estadounidense
         * */
        Scanner sca = new Scanner(System.in);
        ExchangeRateReq exchangeRateReq = new ExchangeRateReq();


        while(true){

            Util.printInterface();

            int userOption = sca.nextInt();
            if (userOption == 7) {
                System.out.println("Saliendo...");
                break;
            } else if (userOption < 1 || userOption > 6) {
                System.out.println("Opcion no valida");
                continue;
            }

            System.out.println("Ingrese la cantidad a convertir:");
            double amount = sca.nextDouble();
            if (amount <= 0) {
                System.out.println("La cantidad debe ser mayor a 0");
                continue;
            }

            try {
                switch (userOption) {
                    case 1 -> Util.printConversionResult(amount, "USD", "ARS",
                            exchangeRateReq.getCurrencyRequest("USD").conversion_rates().get("ARS"),
                            exchangeRateReq.getCurrencyRequest("USD").time_last_update_utc());
                    case 2 -> Util.printConversionResult(amount, "ARS", "USD",
                            exchangeRateReq.getCurrencyRequest("ARS").conversion_rates().get("USD"),
                            exchangeRateReq.getCurrencyRequest("ARS").time_last_update_utc());
                    case 3 -> Util.printConversionResult(amount, "USD", "BRL",
                            exchangeRateReq.getCurrencyRequest("USD").conversion_rates().get("BRL"),
                            exchangeRateReq.getCurrencyRequest("USD").time_last_update_utc());
                    case 4 -> Util.printConversionResult(amount, "BRL", "USD",
                            exchangeRateReq.getCurrencyRequest("BRL").conversion_rates().get("USD"),
                            exchangeRateReq.getCurrencyRequest("BRL").time_last_update_utc());
                    case 5 -> Util.printConversionResult(amount, "USD", "COP",
                            exchangeRateReq.getCurrencyRequest("USD").conversion_rates().get("COP"),
                            exchangeRateReq.getCurrencyRequest("USD").time_last_update_utc());
                    case 6 -> Util.printConversionResult(amount, "COP", "USD",
                            exchangeRateReq.getCurrencyRequest("COP").conversion_rates().get("USD"),
                            exchangeRateReq.getCurrencyRequest("COP").time_last_update_utc());
                    default -> System.out.println("Opcion no valida");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
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
        ConversionHistory conversionHistory = new ConversionHistory();


        while(true){

            Util.printInterface();

            int userOption = sca.nextInt();
            if (userOption == 8) {
                System.out.println("Saliendo...");
                break;
            } else if (userOption < 1 || userOption > 8) {
                System.out.println("Opcion no valida");
                continue;
            }

            double amount = 0;
            if (userOption != 7) {
                System.out.println("Ingrese la cantidad a convertir:");
                amount = sca.nextDouble();
                if (amount <= 0) {
                    System.out.println("La cantidad debe ser mayor a 0");
                    continue;
                }
            }

            try {
                switch (userOption) {
                    case 1 -> {
                        ExchangeRate exchangeRate = exchangeRateReq.getCurrencyRequest("USD");
                        double conversionRate = exchangeRate.conversion_rates().get("ARS");
                        Util.printConversionResult(amount, "USD", "ARS", conversionRate, exchangeRate.time_last_update_utc());
                        conversionHistory.addOperation("USD", "ARS", amount, amount * conversionRate);
                    }
                    case 2 -> {
                        ExchangeRate exchangeRate = exchangeRateReq.getCurrencyRequest("ARS");
                        double conversionRate = exchangeRate.conversion_rates().get("USD");
                        Util.printConversionResult(amount, "ARS", "USD", conversionRate, exchangeRate.time_last_update_utc());
                        conversionHistory.addOperation("ARS", "USD", amount, amount * conversionRate);
                    }
                    case 3 -> {
                        ExchangeRate exchangeRate = exchangeRateReq.getCurrencyRequest("USD");
                        double conversionRate = exchangeRate.conversion_rates().get("BRL");
                        Util.printConversionResult(amount, "USD", "BRL", conversionRate, exchangeRate.time_last_update_utc());
                        conversionHistory.addOperation("USD", "BRL", amount, amount * conversionRate);
                    }
                    case 4 -> {
                        ExchangeRate exchangeRate = exchangeRateReq.getCurrencyRequest("BRL");
                        double conversionRate = exchangeRate.conversion_rates().get("USD");
                        Util.printConversionResult(amount, "BRL", "USD", conversionRate, exchangeRate.time_last_update_utc());
                        conversionHistory.addOperation("BRL", "USD", amount, amount * conversionRate);
                    }
                    case 5 -> {
                        ExchangeRate exchangeRate = exchangeRateReq.getCurrencyRequest("USD");
                        double conversionRate = exchangeRate.conversion_rates().get("COP");
                        Util.printConversionResult(amount, "USD", "COP", conversionRate, exchangeRate.time_last_update_utc());
                        conversionHistory.addOperation("USD", "COP", amount, amount * conversionRate);
                    }
                    case 6 -> {
                        ExchangeRate exchangeRate = exchangeRateReq.getCurrencyRequest("COP");
                        double conversionRate = exchangeRate.conversion_rates().get("USD");
                        Util.printConversionResult(amount, "COP", "USD", conversionRate, exchangeRate.time_last_update_utc());
                        conversionHistory.addOperation("COP", "USD", amount, amount * conversionRate);
                    }
                    case 7 -> {
                        conversionHistory.printHistory();
                        System.out.println("Desea borrar el historial? (s/n)");
                        String option = sca.next();
                        if (option.equalsIgnoreCase("s")) {
                            conversionHistory.clearHistory();
                        } else if (option.equalsIgnoreCase("n")) {
                            System.out.println("Historial no borrado");
                        } else {
                            System.out.println("Opcion no valida");
                        }
                    }
                    default -> System.out.println("Opcion no valida");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
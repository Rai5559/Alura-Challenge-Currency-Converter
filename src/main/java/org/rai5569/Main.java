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
            System.out.println("""
                
                *****************************************
                Bienvenido al conversor de moneda.
                
                1) Dolar -> Peso Argentino
                2) Peso Argentino -> Dolar
                3) Dolar -> Real Brasileno
                4) Real Brasileno -> Dolar
                5) Dolar -> Peso Colombiano
                6) Peso Colombioano -> Dolar
                7) Salir
                
                Elija una opcion valida:
                *****************************************
                
                """);

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
                    case 1 -> System.out.println("El resultado de convertir " + amount + " [USD] a pesos argentinos el dia de: "
                            + exchangeRateReq.getCurrencyRequest("USD").time_last_update_utc() + " es: " +
                            (amount * exchangeRateReq.getCurrencyRequest("USD").conversion_rates().get("ARS")) + " [ARS]");
                    case 2 -> System.out.println("El resultado de convertir " + amount + " [ARS] a dolares el dia de: "
                            + exchangeRateReq.getCurrencyRequest("USD").time_last_update_utc() + " es: " +
                            (amount / exchangeRateReq.getCurrencyRequest("USD").conversion_rates().get("ARS")) + " [USD]");
                    case 3 -> System.out.println("El resultado de convertir " + amount + " [USD] a reales brasileños el dia de: "
                            + exchangeRateReq.getCurrencyRequest("USD").time_last_update_utc() + " es: " +
                            (amount * exchangeRateReq.getCurrencyRequest("USD").conversion_rates().get("BRL")) + " [BRL]");
                    case 4 -> System.out.println("El resultado de convertir " + amount + " [BRL] a dolares el dia de: "
                            + exchangeRateReq.getCurrencyRequest("USD").time_last_update_utc() + " es: " +
                            (amount / exchangeRateReq.getCurrencyRequest("USD").conversion_rates().get("BRL")) + " [USD]");
                    case 5 -> System.out.println("El resultado de convertir " + amount + " [USD] a pesos colombianos el dia de: "
                            + exchangeRateReq.getCurrencyRequest("USD").time_last_update_utc() + " es: " +
                            (amount * exchangeRateReq.getCurrencyRequest("USD").conversion_rates().get("COP")) + " [COP]");
                    case 6 -> System.out.println("El resultado de convertir " + amount + " [COP] a dolares el dia de: "
                            + exchangeRateReq.getCurrencyRequest("USD").time_last_update_utc() + " es: " +
                            (amount / exchangeRateReq.getCurrencyRequest("USD").conversion_rates().get("COP")) + " [USD]");
                    default -> System.out.println("Opcion no valida");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
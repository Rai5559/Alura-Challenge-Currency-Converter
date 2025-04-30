package org.rai5569;

public class Util {

    public static void printConversionResult(double amount, String fromCurrency, String toCurrency, double conversionRate, String date) {
        System.out.println("El resultado de convertir " + amount + " [" + fromCurrency + "] a " + toCurrency + " el dia de: "
                + date + " es: " + (amount * conversionRate) + " [" + toCurrency + "]");
    }

    public static void printInterface(){
        System.out.println("""
                
                *****************************************
                Bienvenido al conversor de moneda.
                
                1) Dolar -> Peso Argentino
                2) Peso Argentino -> Dolar
                3) Dolar -> Real Brasileno
                4) Real Brasileno -> Dolar
                5) Dolar -> Peso Colombiano
                6) Peso Colombioano -> Dolar
                7) Historial de conversiones
                8) Salir
                
                Elija una opcion valida:
                *****************************************
                
                """);
    }
}

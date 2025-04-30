package org.rai5569;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
   private final List<String> operations = new ArrayList<>();

    public void addOperation(String fromCurrency, String toCurrency, double amount, double result) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = now.format(formatter);
        String operation = String.format("Convertido %.2f [%s] a %.2f [%s] el dia de: %s", amount, fromCurrency, result, toCurrency, date);
        operations.add(operation);
    }

    public void printHistory() {
        if (operations.isEmpty()) {
            System.out.println("No hay operaciones en el historial.");
        } else {
            System.out.println("Historial de conversiones:");
            for (String operation : operations) {
                System.out.println(operation);
            }
        }
    }

    public void clearHistory() {
        operations.clear();
        System.out.println("Historial de conversiones borrado.");
    }
}

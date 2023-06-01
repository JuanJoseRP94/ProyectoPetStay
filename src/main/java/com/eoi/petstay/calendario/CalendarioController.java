package com.eoi.petstay.calendario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarioController {
    public static void main(String[] args) {

        LocalDate fechaActual = LocalDate.now();
        String fechaActualFormateada = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Fecha Actual: " + fechaActualFormateada);

        int year = 2023;
        int month = 5; // Mayo
        String calendarHTML = generarCalendarioHTML(year, month);
        System.out.println(calendarHTML);
    }

    public static String generarCalendarioHTML(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);

        // Obtiene el primer día de la semana (Lunes)
        int startDayOfWeek = date.getDayOfWeek().getValue();

        // Obtiene el número de días en el mes
        int daysInMonth = date.lengthOfMonth();

        // Crear un StringBuilder para generar el HTML del calendario
        StringBuilder sb = new StringBuilder();

        // Agregar el encabezado del calendario al StringBuilder
        sb.append("<table>");
        sb.append("<tr><th colspan=\"7\">" + date.getMonth().toString() + " " + year + "</th></tr>");
        sb.append("<tr><th>Lun</th><th>Mar</th><th>Mié</th><th>Jue</th><th>Vie</th><th>Sáb</th><th>Dom</th></tr>");

        // Agregar los días del mes al StringBuilder
        sb.append("<tr>");
        for (int i = 1; i < startDayOfWeek; i++) {
            sb.append("<td></td>");
        }
        for (int day = 1; day <= daysInMonth; day++) {
            sb.append("<td>" + day + "</td>");
            if ((day + startDayOfWeek - 1) % 7 == 0) {
                sb.append("</tr><tr>");
            }
        }
        sb.append("</tr>");

        // Cerrar la tabla
        sb.append("</table>");

        return sb.toString();
    }
}

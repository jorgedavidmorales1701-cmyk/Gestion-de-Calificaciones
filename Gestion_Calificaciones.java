import java.util.ArrayList;
import java.util.Scanner;

public class Gestion_Calificaciones {

    // Función para calcular el promedio de una lista de calificaciones
    public static double calcularPromedio(ArrayList<Double> calificaciones) {
        if (calificaciones.isEmpty()) return 0.0;
        double suma = 0;
        // * Uso de FOR-EACH para sumar
        for (double calif : calificaciones) {
            suma += calif;
        }
        return suma / calificaciones.size();
    }

    // Función para encontrar la calificación más alta
    public static double encontrarMaxima(ArrayList<Double> calificaciones) {
        if (calificaciones.isEmpty()) return 0.0;
        double max = calificaciones.get(0);
        // * Uso de FOR tradicional
        for (int i = 1; i < calificaciones.size(); i++) {
            if (calificaciones.get(i) > max) {
                max = calificaciones.get(i);
            }
        }
        return max;
    }

    // Función para contar cuántas calificaciones están aprobadas (>= 10.0)
    public static int contarAprobados(ArrayList<Double> calificaciones) {
        int aprobados = 0;
        // * Uso de WHILE
        int i = 0;
        while (i < calificaciones.size()) {
            if (calificaciones.get(i) >= 10.0) {
                aprobados++;
            }
            i++;
        }
        return aprobados;
    }

    // Función para validar y leer una calificación entre 0.0 y 20.0
    public static double leerCalificacion(Scanner sc) {
        double calif;
        // * Uso de DO-WHILE (asegura al menos una ejecución y valida entrada)
        do {
            System.out.print("Ingrese una calificación (0.0 a 20.0): ");
            while (!sc.hasNextDouble()) {
                System.out.println("❌ Entrada inválida. Ingrese un número.");
                sc.next(); // descartar entrada no válida
            }
            calif = sc.nextDouble();
            if (calif < 0.0 || calif > 20.0) {
                System.out.println("⚠️ La calificación debe estar entre 0.0 y 20.0.");
            }
        } while (calif < 0.0 || calif > 20.0);
        return calif;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> calificaciones = new ArrayList<>();

        System.out.println("=== SISTEMA DE GESTIÓN DE CALIFICACIONES ===");

        // * Ejemplo de DO-WHILE para repetir ingreso hasta que el usuario decida salir
        char opcion;
        do {
            double calif = leerCalificacion(sc);
            calificaciones.add(calif);

            System.out.print("¿Desea ingresar otra calificación? (s/n): ");
            opcion = sc.next().toLowerCase().charAt(0);
        } while (opcion == 's');

        System.out.println("\n📊 Resumen de calificaciones ingresadas:");

        // * Uso de FOR-EACH para mostrar todas las calificaciones
        int indice = 1;
        for (double calif : calificaciones) {
            System.out.printf("Calificación %d: %.2f\n", indice++, calif);
        }

        // Llamada a funciones
        double promedio = calcularPromedio(calificaciones);
        double maxima = encontrarMaxima(calificaciones);
        int aprobados = contarAprobados(calificaciones);

        System.out.println("\n✅ Estadísticas:");
        System.out.printf("🔹 Total de calificaciones: %d\n", calificaciones.size());
        System.out.printf("🔹 Promedio: %.2f\n", promedio);
        System.out.printf("🔹 Calificación máxima: %.2f\n", maxima);
        System.out.printf("🔹 Estudiantes aprobados (≥10.0): %d\n", aprobados);

        // 👉 Ejemplo adicional de WHILE para una animación simple de carga (simulación)
        System.out.print("\nGenerando reporte final");
        int puntos = 0;
        while (puntos < 10) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            puntos++;
        }
        System.out.println(" ✅ ¡Listo!\n");

        sc.close();
    }
}
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        boolean continuar = true;
        do {
            var operacion = imprimirMenu(consola);
            // Revisar que esté dentro de las opciones
            try {
                continuar = gestionarOperaciones(consola, operacion);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número válido: " + e.getMessage());
            }
            System.out.println("\nEnter para continuar");
            consola.nextLine();
        } while (continuar);
    }

    private static int imprimirMenu(Scanner consola) {
        System.out.println("**** Aplicación Calculadora ****");
        // Mostramos el menú
        System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicación
                4. División
                5. Salir
                """);
        System.out.print("Operación a realizar?: ");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean gestionarOperaciones(Scanner consola, int operacion) {
        if (operacion >= 1 && operacion <= 4) {
            var operando1 = ingresarNumero1(consola);
            var operando2 = ingresarNumero2(consola);
            switch (operacion) {
                case 1 -> {
                    sumar(operando1, operando2);
                }
                case 2 -> {
                    restar(operando1, operando2);
                }
                case 3 -> {
                    multiplicar(operando1, operando2);
                }
                case 4 -> {
                    dividir(operando1, operando2);
                }
                default -> {
                    System.out.println("Operación no reconocida");
                }
            }
        } else if (operacion == 5) {
            System.out.println("Gracias por usar la calculadora");
            return false;
        } else {
            System.out.println("La opción seleccionada no es válida");
        }
        return true;
    }

    private static int ingresarNumero1(Scanner consola) {
        System.out.print("Proporciona el primer número: ");
        return Integer.parseInt(consola.nextLine());
    }

    private static int ingresarNumero2(Scanner consola) {
        System.out.print("Proporciona el segundo número: ");
        return Integer.parseInt(consola.nextLine());
    }

    private static void sumar(int numero1, int numero2) {
        System.out.println("El resultado de la suma es: " + (numero1 + numero2));
    }

    private static void restar(int numero1, int numero2) {
        System.out.println("El resultado de las resta es: " + (numero1 + numero2));
    }

    private static void multiplicar(int numero1, int numero2) {
        System.out.println("El resultado de la multiplicación es: " + (numero1 + numero2));
    }

    private static void dividir(int numero1, int numero2) {
        System.out.println("El resultado de la división es: " + (numero1 + numero2));
    }

}

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("1. Dólar -> Peso Argentino.");
            System.out.println("2. Peso Argentino -> Dólar.");
            System.out.println("3. Dólar -> Real Brasileño.");
            System.out.println("4. Real Brasileño -> Dólar.");
            System.out.println("5. Peso Colombiano -> Dólar.");
            System.out.println("6. Dólar -> Peso Colombiano.");
            System.out.println("7. Dólar -> Peso Mexicano.");
            System.out.println("8. Peso Mexicano -> Dólar.");
            System.out.println("9. SALIR.");
            System.out.println("++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Elija una opción válida: ");
            int opcion = 0;
            try {
                opcion = lectura.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                lectura.next();
                continue;
            }

            if (opcion == 9) {
                System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = 0.0;
            try {
                cantidad = lectura.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                lectura.next(); // Limpiar la entrada incorrecta
                continue;
            }

            Moneda moneda = consulta.obtenerTasas("USD");

            if (moneda == null) {
                System.out.println("Error al obtener las tasas de conversión.");
                continue;
            }

            double resultado = 0.0;
            String conversion = "";
            switch (opcion) {
                case 1:
                    resultado = cantidad * moneda.ars();
                    conversion = cantidad + " USD -> " + resultado + " ARS";
                    break;
                case 2:
                    resultado = cantidad / moneda.ars();
                    conversion = cantidad + " ARS -> " + resultado + " USD";
                    break;
                case 3:
                    resultado = cantidad * moneda.brl();
                    conversion = cantidad + " USD -> " + resultado + " BRL";
                    break;
                case 4:
                    resultado = cantidad / moneda.brl();
                    conversion = cantidad + " BRL -> " + resultado + " USD";
                    break;
                case 5:
                    resultado = cantidad / moneda.cop();
                    conversion = cantidad + " COP -> " + resultado + " USD";
                    break;
                case 6:
                    resultado = cantidad * moneda.cop();
                    conversion = cantidad + " USD -> " + resultado + " COP";
                    break;
                case 7:
                    resultado = cantidad * moneda.mxn();
                    conversion = cantidad + " USD -> " + resultado + " MXN";
                    break;
                case 8:
                    resultado = cantidad / moneda.mxn();
                    conversion = cantidad + " MXN -> " + resultado + " USD";
                    break;
                default:
                    System.out.println("Opción no válida, por favor elija una opción válida.");
                    continue;
            }

            System.out.println(conversion);
            //System.out.println("+++++++++++++++++++++++++++++++++++++++");
        }
        lectura.close();
    }
}

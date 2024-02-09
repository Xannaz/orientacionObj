package orientacionObjetos;
import java.util.*;
public class CalculadoraCambio {

    private static final int[] BILLETES = {500, 200, 100, 50, 20, 10, 5};
    private static final int[] MONEDAS_EUROS = {2, 1};
    private static final int[] MONEDAS_CENTIMOS = {50, 20, 10, 5, 2, 1};

    public static Map<Integer, Integer> calcularCambio(int total, int pago) {
        int cambio = pago - total;
        Map<Integer, Integer> resultado = new HashMap<>();

        for (int billete : BILLETES) {
            if (cambio >= billete) {
                int cantidad = cambio / billete;
                resultado.put(billete, cantidad);
                cambio = cambio % billete;
            }
        }

        for (int moneda : MONEDAS_EUROS) {
            if (cambio >= moneda) {
                int cantidad = cambio / moneda;
                resultado.put(moneda, cantidad);
                cambio = cambio % moneda;
            }
        }

        for (int centimo : MONEDAS_CENTIMOS) {
            if (cambio >= centimo) {
                int cantidad = cambio / centimo;
                resultado.put(centimo, cantidad);
                cambio = cambio % centimo;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el total de la compra en euros: ");
        int totalCompra = scanner.nextInt();

        System.out.print("Ingrese el monto pagado por el cliente en euros: ");
        int pagoCliente = scanner.nextInt();

        Map<Integer, Integer> cambio = calcularCambio(totalCompra, pagoCliente);

        System.out.println("Cambio:");
        for (Map.Entry<Integer, Integer> entry : cambio.entrySet()) {
            int denominacion = entry.getKey();
            int cantidad = entry.getValue();
            if (denominacion >= 100) {
                System.out.println(cantidad + " x €" + denominacion / 100.0 + " billete(s)");
            } else {
                System.out.println(cantidad + " x " + denominacion + " euros");
            }
        }

        scanner.close();
    }
}
	


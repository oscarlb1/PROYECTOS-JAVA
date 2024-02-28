import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int codigo_cuenta = 23462;
        boolean seguir = true;
        Scanner scanner = new Scanner(System.in);
        ArrayList<CuentaBancaria> miscuentas = new ArrayList<CuentaBancaria>();

        while (seguir) {
            System.out.println("MENU");
            System.out.println("-----------");
            System.out.println("1. Crear cuenta bancaria");
            System.out.println("2. Crear movimiento");
            System.out.println("3. Ver movimientos");
            System.out.println("4. Ver un movimiento");
            System.out.println("5. Borrar movimiento");
            System.out.println("6. Salir");

            System.out.println("Elige una opción: ");
            int opcion = scanner.nextInt();
            String nombre = scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca su nombre, apellido y Dni del titular para crear una cuenta bancaria: ");
                    nombre = scanner.nextLine();
                    String apellido = scanner.nextLine();
                    String dni = scanner.nextLine();
                    Titular titular1 = new Titular(nombre, apellido, dni);
                    long ms = System.currentTimeMillis();
                    Date fechaActual = new Date(ms);

                    System.out.println("Introduzca el tipo de cuenta para crear una cuenta bancaria: ");
                    String tipo_cuenta = scanner.nextLine();
                    CuentaBancaria cuenta1 = new CuentaBancaria(codigo_cuenta + "GM", titular1, fechaActual, tipo_cuenta, 0f);
                    // Cuenta creada !!!
                    miscuentas.add(cuenta1);
                    codigo_cuenta = codigo_cuenta + 1;
                    System.out.println("Cuenta creada");
                    /*cuentaActual = cuenta1;
                    cuentas.add(cuenta1);*/
                    break;
                case 2:
                    System.out.println("Introduzca concepto, tipo de movimiento y el importe: ");
                    String concepto = scanner.nextLine();
                    String tipoMovimiento = scanner.nextLine();
                    float importe = scanner.nextFloat();
                    ms = System.currentTimeMillis();
                    Date fechaActual2 = new Date(ms);
                    MovimientoBancario movimiento1 = new MovimientoBancario("1", fechaActual2, concepto, tipoMovimiento, importe);
                    System.out.println("Movimiento hecho");
                    break;
                case 3:
                    System.out.println("Introduce las fechas entre las cuales ver los movimientos realizados: ");

                    /*for (CuentaBancaria cuenta : cuentas
                    ) {
                        if (cuentaActual == cuenta) {
                            //Date fechaInicio =
                            //cuentaActual.verMovimientos(fecha, fecha);
                        }
                    }*/
                    break;
                case 6:
                    seguir = false;
            }
        }
        }


}
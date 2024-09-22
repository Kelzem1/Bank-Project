package AppCuenta;

import java.util.ArrayList;
import java.util.Scanner;

public class SucursalBanco {

    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Cuenta> cuentas = new ArrayList<>();
    private static Cuenta cuentaActiva = null;
    private static int contadorCuenta = 1;

    public static void main(String[] args) {
        int option = 0;
        while (option != 4) {
            showMainMenu();
            option = Integer.parseInt(entrada.nextLine());
            switch (option) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    crearCuenta();
                    break;
                case 3:
                    seleccionarCuenta();
                    break;
                case 4:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.err.println("❌❌ Opcion no valida, seleciona una opcion entre 1 y 4 ❌❌");
            }
        }
    }

    static public void showMainMenu() {

        String s = """

                MENU PRINCIPAL 
                Selecciona una opcion
                1 - CREAR CLIENTE
                2 - CREAR CUENTA
                3 - SELECCIONAR CUENTA
                4 - SALIR

                """;
        System.out.println(s);
    }

    static public void cuentaMenu() {
        String s = """

                MENU DE CLIENTE
                Selecciona una opcion: 
                1 - Ingresar dinero.
                2 - Retirar dinero.
                3 - Ver datos de la cuenta.
                4 - Salir al MENU PRINCIPAL.

                """;
        System.out.println(s);
    }

    static public void menuTipoCuenta() {
        String s = """

                QUE TIPO DE CUENTA QUIERES CREAR?: 
                Selecciona una opcion: 
                1 - Crear Cuenta Corriente.
                2 - Crear Cuenta Vivienda.
                3 - Crear Fondo de Inversion.
                4 - Salir al MENU PRINCIPAL.

                """;
        System.out.println(s);
    }

    static void crearCliente() {
        System.out.println("Escribe el nombre del cliente: ");
        String nombre = entrada.nextLine();
        System.out.println("Escribre el apellido del cliente: ");
        String apellido = entrada.nextLine();
        System.out.println("Escribe la direccion del cliente: ");
        String direccion = entrada.nextLine();
        System.out.println("Escribe la localidad del cliente: ");
        String localidad = entrada.nextLine();
        System.out.println("👍🏽👍🏽CLIENTE CREADO CON EXITO!!👍🏽👍🏽");
        clientes.add(new Cliente(nombre, apellido, direccion, localidad));

    }

    static void crearCuenta() {
        if (clientes.isEmpty()) {
            System.out.println("No hay ningun cliente. ");
            return;

        }

        //Obtenemos en cliente
        Cliente cliente = validarCliente();

        //Obtenemos la cuenta valida.
        Cuenta cuenta = validarCuenta(cliente);

        cuentas.add(cuenta);
        System.out.println("👌🏽👌🏽CUENTA CREADA CON EXITO!!👌🏽👌🏽");

    }

    static Cuenta validarCuenta(Cliente c) {
        int opcion;
        while (true) {
            menuTipoCuenta();
            opcion = Integer.parseInt(entrada.nextLine());
            switch (opcion) {
                case 1:
                    return new CuentaCorriente(contadorCuenta++, c);
                case 2:
                    return new CuentaVivienda(contadorCuenta++, c);
                case 3:
                    return new FondoInversion(contadorCuenta++, c);

            }
        }
    }

    //Creamos un metodo de la clase cliente que valida si el cliente esta en el array de clientes. Le pasamos un parametro a comprar.
    static Cliente validarCliente() {

        String nombre;

        while (true) {
            System.out.println("Escribe el nombre del cliente para abrir una cuenta nueva");
            for (Cliente c : clientes) {
                System.out.println(c.getNombre());
            }
            nombre = entrada.nextLine();
            for (Cliente c : clientes) {
                if (c.getNombre().equals(nombre)) {
                    return c;
                }
            }
        }
    }

    static void seleccionarCuenta() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay ninguna cuenta. ");
            return;
        }

        int numCuenta;
        do {
            System.out.println("Seleciona un numero de cuenta");
            for (Cuenta c : cuentas) {
                System.out.println(c.toString());
            }
            numCuenta = Integer.parseInt(entrada.nextLine());
        } while (!validarCuenta(numCuenta));
        seleccionarOpcionCuenta();

    }

    static boolean validarCuenta(int numCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta() == numCuenta) {
                cuentaActiva = c;
                return true;
            }
        }
        return false;
    }

    static void seleccionarOpcionCuenta() {

        int opcionCuenta = 0;
        while (opcionCuenta != 4) {
            cuentaMenu();
            opcionCuenta = Integer.parseInt(entrada.nextLine());
            switch (opcionCuenta) {
                case 1:
                    ingresar();
                    break;
                case 2:
                    retirar();
                    break;
                case 3:
                    System.out.println(cuentaActiva.showAllData());
                    ;
                    break;
                case 4:
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opcion no valida");
            }
        }

    }

    static void ingresar() {
        System.out.println("Indica la cantidad que quieres ingresar: ");
        int cantidad = Integer.parseInt(entrada.nextLine());
        cuentaActiva.ingreso(cantidad);
    }

    static void retirar() {
        System.out.println("Indica la cantidad que quieres retirar: ");
        int cantidad = Integer.parseInt(entrada.nextLine());
        cuentaActiva.retiro(cantidad);
    }
}

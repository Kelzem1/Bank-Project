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

        System.out.println("MENU PRINCIPAL");
        System.err.println("Selecciona una opcion: ");

        System.out.println("1 - CREAR CLIENTE");
        System.out.println("2 - CREAR CUENTA");
        System.out.println("3 - MANTENIMIENTO DE CUENTA");
        System.out.println("4 - SALIR");

    }

    static public void cuentaMenu() {
        System.out.println("MENU CUENTA");
        System.out.println("Selecciona una opcion: ");

        System.out.println("1 - Ingresar");
        System.out.println("2- Retirar");
        System.out.println("3 - Ver datos cuenta");
        System.out.println("4 - Volver al menu principal");
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

        clientes.add(new Cliente(nombre, apellido, direccion, localidad));
    }

    static void crearCuenta() {
        if (clientes.isEmpty()) {
            System.out.println("No hay ningun cliente. ");
            return;

        }
        String nombre;
        Cliente cliente;
        do {
            System.out.println("Escribe el nombre del cliente para abrir una cuenta nueva");
            for (Cliente c : clientes) {
                System.out.println(c.getNombre());
            }
            nombre = entrada.nextLine();
            cliente = validarCliente(nombre);
        } while (cliente == null);

        cuentas.add(new Cuenta(contadorCuenta++, 0, cliente));
    }
    //Creamos un metodo de la clase cliente que valida si el cliente esta en el array de clientes. Le pasamos un parametro a comprar.
    static Cliente validarCliente(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }
    static void seleccionarCuenta() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay ninguna cuenta. ");
            return;
        }
        
        int numCuenta;
        do {
            System.out.println("Seleciona un numero de cuenta");
            for(Cuenta c: cuentas){
                System.out.println(c.toString());
            }
            numCuenta = Integer.parseInt(entrada.nextLine());
        } while (!validarCuenta(numCuenta));
        seleccionarOpcionCuenta();

    }
      static boolean validarCuenta(int numCuenta){
        for (Cuenta c : cuentas){
            if(c.getNumeroCuenta() == numCuenta){
                cuentaActiva = c;
                return true;
            }
        }
        return false;
    }
    static void seleccionarOpcionCuenta(){
        cuentaActiva.showAllData();
    }
}

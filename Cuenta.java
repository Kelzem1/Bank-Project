package AppCuenta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Cuenta {

    private int numeroCuenta;
    private double saldo;
    private Cliente titular;
    private ArrayList<Moves> moves;


    /*CONSTRUCTORES */
    public Cuenta(int numeroCuenta, double saldo, Cliente titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
        this.moves = new ArrayList<Moves>();
    }

    /*GETTERS Y SETTERS */
    public double getSaldo() {
        return saldo;
    }

    public void setSadlo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void getNombreCliente() {
        System.out.println(titular.nombreCompleto());
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setNombreCliente(Cliente titular) {
        this.titular = titular;
    }

    /*METODOS */
    public void ingreso(double cantidad) {
        if (cantidad < 0) {
            System.err.println("No puedes introducir un numero negativo");
            return;
        }
        saldo += cantidad;
        moves.add(new Moves(LocalDateTime.now(), cantidad, Moves.INGRESO));
        System.out.println("Se ingresado correctamente " + cantidad + "€" + "en la cuenta");
    }

    public void retiro(double cantidad) {
        if (cantidad < 0 || cantidad > saldo) {
            System.out.println("Importe no valido");
            return;
        }
        saldo -= cantidad;
        moves.add(new Moves(LocalDateTime.now(), cantidad, Moves.RETIRO));
        System.out.println("Se ha retirado correctamente " + cantidad + "€ en la cuenta");
    }

    private String obtenerMoves() {
        String s = "";
        for (Moves m : moves) {
            s += m.toString() + "\n";
        }
        return s;
    }

    public void showAllData() {
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println(titular.nombreCompleto());
        System.out.println("Direccion: "+ titular.getDireccion());
        System.out.println("Localidad: " + titular.getLocalidad());
        System.out.println("Saldo: " + saldo);
        System.out.println("-------------------------MOVIMIENTOS---------------------------");
        System.out.println(obtenerMoves());
    }

    @Override
    public String toString() {
        return "Cuenta [numeroCuenta=" + numeroCuenta + ", titular=" + titular.nombreCompleto() + "]";
    }

    private class Moves {

        private static final byte INGRESO = 0;
        private static final byte RETIRO = 1;

        private LocalDateTime fechaHora;
        private double importe;
        private double saldoFinal;
        private byte tipo;

        public Moves(LocalDateTime fechaHora, double importe, byte tipo) {
            this.fechaHora = fechaHora;
            this.importe = importe;
            this.saldoFinal = saldo;
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return (tipo == INGRESO ? "INGRESO 🤑" : "RETIRO 💸")
                    + "[Fecha =  " + fechaHora.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
                    + ", hora = " + fechaHora.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
                    + ", importe = " + importe + "€"
                    + ", saldo = " + saldoFinal + "€"
                    + "]";

        }
    }

}

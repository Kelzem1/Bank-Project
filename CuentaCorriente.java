package AppCuenta;

public class CuentaCorriente extends Cuenta {
    public CuentaCorriente(int numeroCuenta, Cliente titular){
        super(numeroCuenta, 0, titular);
    }
    @Override
    public String showAllData(){
        return
        "Numero de cuenta: " + numeroCuenta + " Cuenta Corrientes" + "\n"
        + "Titular: " + titular.nombreCompleto() + "\n"
        + "Direccion: " + titular.getDireccion() + "\n"
        + "Localidad:" + titular.getLocalidad() + "\n"
        + "Saldo: " + saldo + "\n"
        + "-------------------------MOVIMIENTOS--------------------------- \n"
        + obtenerMoves();
    }
}


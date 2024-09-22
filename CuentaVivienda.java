package AppCuenta;

public class CuentaVivienda extends Cuenta {
    
    public CuentaVivienda(int numeroCuenta, Cliente titular) {
        super(numeroCuenta, 1000, titular);
    }
    @Override
    public String showAllData(){
        return
        "Numero de cuenta: " + numeroCuenta + " Cuenta Vivienda" + "\n"
        + "Titular: " + titular.nombreCompleto() + "\n"
        + "Direccion: " + titular.getDireccion() + "\n"
        + "Localidad:" + titular.getLocalidad() + "\n"
        + "Saldo: " + saldo + "\n"
        + "-------------------------MOVIMIENTOS--------------------------- \n"
        + obtenerMoves();
    }
    
}

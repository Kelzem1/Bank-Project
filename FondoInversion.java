package AppCuenta;

public class FondoInversion extends Cuenta {
    private double interes;

    public FondoInversion(int numeroCuenta, Cliente titular) {
        super(numeroCuenta, 5000, titular);
        calcInteres();
        
    }
    public double getInteres(){
        return interes;
    }
    public void calcInteres(){
        if( saldo >= 100_000) interes = 5;
        else if(saldo >= 50_000) interes = 4;
        else interes = 2;
    }
    @Override
    public String showAllData(){
        return
        "Numero de cuenta: " + numeroCuenta + " Fondo de inversion al " +interes +"%" + "\n"
        + "Titular: " + titular.nombreCompleto() + "\n"
        + "Direccion: " + titular.getDireccion() + "\n"
        + "Localidad:" + titular.getLocalidad() + "\n"
        + "Saldo: " + saldo + "\n"
        + "-------------------------MOVIMIENTOS--------------------------- \n"
        + obtenerMoves();
    }
}

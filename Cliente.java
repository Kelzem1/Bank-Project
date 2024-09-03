package AppCuenta;

import java.time.LocalDate;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String localidad;
    private LocalDate fNacimiento;

    /*CONSTRUCTORES*/

    public Cliente(String nombre, String apellidos, String direccion, String localidad){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        
    }

    /*METODOS */
    public String getNombre(){
        return nombre;
    }
    public String nombreCompleto(){
        return "Nombre: " + nombre + " " + apellidos; 
    }
    public String getDireccion (){
        return "Calle: " +  direccion;
    }
    public String getLocalidad(){
        return localidad;
    }
    public String direccionCompleta(){
        return "Ciudad: "+ localidad + "Calle: " + direccion;
    }
}

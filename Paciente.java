/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructura de datos
 * Hoja de trabajo 7
 * Sofi Lam 21548
 * Daniel Gómez 21429
 * Grupo 2
 */

/**
 * Clase paciente para facilitar el manejo de datos
 * 
 * @author Grupo 2
 * @version Paciente Class 1.1
 */
public class Paciente{
    private int numero_paciente;
    private String nombre;
    private String caso;
    private String prioridad;

    /***
     * Constructor
     * 
     * @author Grupo 2
     * @version Paciente 1.1
     */
    public Paciente(int numero_paciente, String name, String pacient_case, String priority){
        this.numero_paciente = numero_paciente;
        this.nombre = name;
        this.caso = pacient_case;
        this.prioridad = priority;
    }

    /**
     * toString para obtencion de datos
     * 
     * @author Grupo 2
     * @return String
     * @version toString 1.1
     */
    public String toString(){
        return "Paciente No. "+Integer.toString(this.numero_paciente)+": "+this.nombre+"\nCaso Clinico: "+this.caso+"\nPrioridad: "+this.prioridad;
    }

    /**
     * Getter de prioridad
     * 
     * @author Grupo 2
     * @return String
     * @version get_prioridad 1.1
     */
    public String get_prioridad(){
        return this.prioridad;
    }
}

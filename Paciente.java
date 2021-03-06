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
public class Paciente implements Comparable <Paciente>{
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

    /***
     * Metodo para comparar el Paciente actual y otro
     * 
     * @author Grupo 2
     * @version equals 1.1
     * @return boolean
     * @param Paciente
     */
    public boolean equals(Paciente other){
        return this.prioridad.equals(other.get_prioridad());
    }

    /***
     * Metodo para poder reconocer la prioridad con PriorityQueue de un objeto
     * 
     * @author Grupo 2
     * @version compareTo 1.1
     * @return int
     * @param Paciente
     */
    public int compareTo(Paciente other){
        if((this.equals(other))||(this.prioridad.compareTo(other.get_prioridad())==0)){
            return 0;
        }
        else if((this.prioridad.compareTo(other.get_prioridad()))>0){
            return 1;
        }
        else{
            return -1;
        }
    }

    /**
     * toString para obtencion de datos
     * 
     * @author Grupo 2
     * @return String
     * @version toString 1.1
     */
    public String toString(boolean atendiendo){
        String s = "";
        if(atendiendo){
            s = "Atendiendo ";
        }
        return s+"Paciente No. "+Integer.toString(this.numero_paciente)+": "+this.nombre+"\nCaso Clinico: "+this.caso+"\nPrioridad: "+this.prioridad;
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

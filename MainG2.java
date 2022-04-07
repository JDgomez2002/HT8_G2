/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructura de datos
 * Hoja de trabajo 7
 * Sofi Lam 21548
 * Daniel Gómez 21429
 * Grupo 2
 */

import java.util.Scanner;
import java.util.PriorityQueue;
import java.io.File;

public class MainG2{
    public static void main(String[] args) {
        Vista myVista = new Vista();
        FileReader myFileReader = new FileReader();

        PriorityQueue<Paciente> patients = myFileReader.leer_pacientes();

        boolean continuar = true;
        int opcion = 0;

        myVista.inicio();

        while(continuar){
            opcion = myVista.menu_principal();
            switch (opcion) {
                //Atender Pacientes
                case 1:
                    int numero_pacientes = myVista.numero_pacientes_atender(patients);
                    if(!(numero_pacientes==0)){
                        myVista.mostrar_pacientes_atendidos(patients, numero_pacientes);                 
                    }
                    break;

                //Mostrar Pacientes en cola
                case 2:
                    myVista.mostrar_pacientes_cola(patients);
                    break;

                //Agregar Pacientes
                case 3:
                    Paciente patient = myVista.agregar_paciente();
                    patients.add(patient);
                    break;
            
                //Salir
                default:
                    myVista.despedida();
                    continuar = false;
                    break;
            }
        }
    }
}

class Vista{

    private Scanner scan = new Scanner(System.in);

    public void enter(){
        System.out.println();
        System.out.print("\tPresione Enter para continuar... ");
        this.scan = new Scanner(System.in);
        String texto = scan.nextLine();
    }

    private int solicitar_int(String s, int inferior, int superior){
        inferior -= 1;
        superior += 1;
        int entero = 0;
        boolean continuar = true;
            while(continuar){
                try{
                System.out.print(s);
                this.scan = new Scanner(System.in);
                int numero = scan.nextInt();
                if((numero>inferior)&&(numero<superior)){
                    entero = numero;
                    System.out.println("----------------------------------------------------");
                    continuar = false; 
                }
                else{
                    System.out.println("\t Error: debe de ingresar un entero entre "+(inferior+1)+" y "+(superior-1)+".");   
                    System.out.println();              
                }
                }
                catch(Exception e){
                    System.out.println("\t Error: debe de ingresar un entero entre "+(inferior+1)+" y "+(superior-1)+".");   
                    System.out.println();
                }
            }
        
        return entero;
    }

    private String solicitar_string(String s){
        String txt = "";
        boolean continuar = true;
        try{
            System.out.print(s);
            while(continuar){
                this.scan = new Scanner(System.in);
                String texto = scan.nextLine();
                if(texto.equals("")){
                    System.out.println("\t Error: debe de ingresar un texto valido.");
                }
                else if(texto.equals("\n")){
                    txt = texto;
                    System.out.println("----------------------------------------------------");
                    continuar = false; 
                }
                else{
                    txt = texto;
                    System.out.println("----------------------------------------------------");
                    continuar = false;                   
                }
            }
        }
        catch(Exception e){
            System.out.println("\t Error: debe de ingresar un texto valido.");
        }
        return txt;
    }

    public void inicio(){
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("       BIENVENIDO AL HOSPITAL DEL GRUPO 2!");
        System.out.println("----------------------------------------------------");
        System.out.println("En este hospital podras ver a los pacientes en cola,");
        System.out.println("atender a un numero de pacientes especifico y tambien");
        System.out.println("agregar pacientes para ser atendidos...");
        enter();
        System.out.println("----------------------------------------------------");
    }

    public int menu_principal(){
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("                 MENU PRINCIPAL");
        System.out.println("----------------------------------------------------");
        System.out.println("1. Atender Pacientes");
        System.out.println("2. Mostrar pacientes en cola");
        System.out.println("3. Agregar pacientes");
        System.out.println("4. Salir");
        System.out.println();
        String s = "Ingrese su desicion: ";
        int i = solicitar_int(s, 1, 4);
        return i;
    }

    public int numero_pacientes_atender(PriorityQueue<Paciente> myQueue){
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("                 Atender Pacientes");
        System.out.println("----------------------------------------------------");
        if(myQueue.size()==0){
            System.out.println("Lo sentimos, no hay pacientes en cola...");
            enter();
            return 0;
        }
        else{
            System.out.println("Numero actual de pacientes: "+myQueue.size());
            String s = "Ingrese el numero de pacientes por atender...\n>>> ";
            int numero = solicitar_int(s, 1, myQueue.size());
            return numero;
        }
    }

    public void mostrar_pacientes_atendidos(PriorityQueue<Paciente> myQueue, int i){
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("               Atendiendo Pacientes...");
        System.out.println("----------------------------------------------------");
        for(int k = 0; k<i ;k++){
            System.out.println(myQueue.remove().toString(true));
            System.out.println();
        }
        System.out.println();
        System.out.println("Numero de pacientes restantes por atender: "+myQueue.size());
        System.out.println("----------------------------------------------------");
        enter();
    }

    public void mostrar_pacientes_cola(PriorityQueue<Paciente> myQueue){
        int i = myQueue.size();
        PriorityQueue<Paciente> myQueue2 = new PriorityQueue<Paciente>(myQueue);
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("               Pacientes en Cola...");
        System.out.println("----------------------------------------------------");
        for(int k = 0; k<i ;k++){
            System.out.println(myQueue2.remove().toString(false));
            System.out.println();
        }
        System.out.println();
        System.out.println("Numero de pacientes en cola: "+myQueue.size());
        System.out.println("----------------------------------------------------");
        enter();
    }

    public Paciente agregar_paciente(){
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("               Agregar Paciente!");
        System.out.println("----------------------------------------------------");
        System.out.println("Para nosotros el tiempo es oro!!!");
        System.out.println("Ingresa los datos del paciente...");
        System.out.println();
        String s4 = "Ingresa el Numero de paciente: ";
        int i = solicitar_int(s4, 1, 100);
        String s1 = "Ingresa el nombre del paciente: ";
        s1 = solicitar_string(s1);
        String s2 = "Ingresa el caso clinico del paciente: ";
        s2 = solicitar_string(s2);
        String s3 = "Ingresa la prioridad del paciente: ";
        s3 = solicitar_string(s3);
        Paciente p = new Paciente(i, s1, s2, s3);
        System.out.println();
        System.out.println("\tPaciente agregado con Exito!!!");
        System.out.println();
        System.out.println("----------------------------------------------------");
        enter();
        return p; 
    }

    public void despedida(){
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("Muchas gracias por usar el hospital del Grupo 2!");
        System.out.println();
        System.out.println("Vuelve Pronto!!!");
        System.out.println("----------------------------------------------------");
        System.out.println();
    }
    
}

class FileReader{

    public PriorityQueue<Paciente> leer_pacientes(){

        PriorityQueue<Paciente> myPacientes = new PriorityQueue<Paciente>();

        try{
            String s = "pacientes.txt";
            File myFile = new File(s);
            Scanner scan = new Scanner(myFile);

            Paciente patient = null;
            String info = "";
            int contador = 0;

            while(scan.hasNextLine()){
                contador++;
                info = scan.nextLine();
                String[] info_separada = info.split(",");
                patient = new Paciente(contador, info_separada[0], info_separada[1], info_separada[2]);
                myPacientes.add(patient);
            }

            scan.close();
        }
        catch(Exception e){
            String s = "FileReader: leer_pacientes(): "+e.getMessage();
            throw new RuntimeException(s);
        }

        return myPacientes;
    }
}
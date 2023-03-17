import java.util.ArrayList;
import java.util.Scanner;

public class EPS {

    public static void main(String[] args) {
        ArrayList<Paciente> listaTurnos = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Obtener turno");
            System.out.println("2. Atender turno");
            System.out.println("3. Ver cola de turnos");
            System.out.println("4. Salir");

            int opcion = input.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("\nIngrese su nombre y apellidos:");
                    String nombre = input.next();
                    System.out.println("Ingrese su edad:");
                    int edad = input.nextInt();
                    System.out.println("Ingrese su afiliación (POS/PC):");
                    String afiliacion = input.next();
                    System.out.println("¿Tiene alguna condición especial? (S/N):");
                    String respuesta = input.next();

                    String condicionEspecial = null;
                    if (respuesta.equalsIgnoreCase("S")) {
                        System.out.println("Ingrese su condición especial:");
                        condicionEspecial = input.next();
                    }

                    Paciente paciente = new Paciente(nombre, edad, afiliacion, condicionEspecial);
                    listaTurnos.add(paciente);

                    System.out.println("\nSu número de turno es: " + listaTurnos.size());
                }

                case 2 -> {
                    if (listaTurnos.isEmpty()) {
                        System.out.println("\nNo hay pacientes en la cola.");
                    } else {
                        Paciente pacienteAtendido = listaTurnos.remove(0);
                        System.out.println("\nEl siguiente paciente es: " + pacienteAtendido.getNombre());
                    }
                }

                case 3 -> {
                    if (listaTurnos.isEmpty()) {
                        System.out.println("\nNo hay pacientes en la cola.");
                    } else {
                        System.out.println("\nLa cola de turnos es:");
                        for (int i = 0; i < listaTurnos.size(); i++) {
                            Paciente pacienteEnCola = listaTurnos.get(i);
                            System.out.println((i+1) + ". " + pacienteEnCola.getNombre());
                                    
                        }
                    }
                }

                case 4 -> {
                    System.out.println("\n¡Hasta luego!");
                    System.exit(0);
                }

                default -> System.out.println("\nOpción inválida.");
            }

            if (!listaTurnos.isEmpty()) {
                System.out.println("\nLlamando al siguiente turno en 5 segundos...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Paciente pacienteLlamado = listaTurnos.get(0);
                System.out.println("\nEl siguiente paciente es: " + pacienteLlamado.getNombre());
            }
        }
    }
}
class Paciente {
    String nombre ;
    int edad;
    String afiliado;
   String condicionEspecial;
    
    Paciente(String nombre,int edad,String afiliaciones,String condicionEspecial){
    }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
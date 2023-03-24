/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parking;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Estudiante
 */
public class Parking {

    public static void main(String[] args) {
        ArrayList<String> placaList = new ArrayList<>();
        ArrayList<String> tipoVehiculoList = new ArrayList<>();
        ArrayList<String> horaIngresoList = new ArrayList<>();
        ArrayList<Integer> numeroVehiculoList = new ArrayList<>();
        int numVehiculo = 1;
        
        Scanner input = new Scanner(System.in);
        char continuar = 's';
        while (continuar == 's' || continuar == 'S') {
            System.out.println("Ingreso de vehículo: ");
            System.out.print("Placa: ");
            String placa = input.next();
            System.out.print("Tipo de vehículo: ");
            String tipoVehiculo = input.next();
            System.out.print("Hora de ingreso (en formato 24 horas): ");
            String horaIngreso = input.next();
            
            placaList.add(placa);
            tipoVehiculoList.add(tipoVehiculo);
            horaIngresoList.add(horaIngreso);
            numeroVehiculoList.add(numVehiculo);
            numVehiculo++;
            
            System.out.print("¿Desea ingresar otro vehículo? (S/N): ");
            continuar = input.next().charAt(0);
        }
        
        System.out.println("Tabla de vehículos ingresados: ");
        System.out.println("Número\tPlaca\tTipo\tHora\tValor a pagar");
        for (int i = 0; i < placaList.size(); i++) {
            String placa = placaList.get(i);
            String tipoVehiculo = tipoVehiculoList.get(i);
            String horaIngreso = horaIngresoList.get(i);
            int num = numeroVehiculoList.get(i);
            double valorAPagar = calcularValorAPagar(horaIngreso, tipoVehiculo);
            System.out.println(num + "\t" + placa + "\t" + tipoVehiculo + "\t" + horaIngreso + "\t" + valorAPagar);
        }
    }
    
    public static double calcularValorAPagar(String horaIngreso, String tipoVehiculo) {
        int hora = Integer.parseInt(horaIngreso.substring(0, 2));
        int minutos = Integer.parseInt(horaIngreso.substring(3));
        double valorHora = 0;
        double valorMinutos = 0;
        
        if (tipoVehiculo.equals("carro")) {
            valorHora = 2000;
            valorMinutos = 33.33;
        } else if (tipoVehiculo.equals("moto")) {
            valorHora = 1000;
            valorMinutos = 16.67;
        }
        
        double valorAPagar = 0;
        if (hora >= 8 && hora <= 17) {
            int horasEstacionado = 24 - (hora - 8);
            int minutosEstacionado = 60 - minutos;
            valorAPagar = valorHora * horasEstacionado + valorMinutos * minutosEstacionado;
        } else {
            valorAPagar = valorHora * 8;
        }
        
        return valorAPagar;
}
``


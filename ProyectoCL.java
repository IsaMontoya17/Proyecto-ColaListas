
package pilas;

import javax.swing.JOptionPane;

public class ProyectoCL {

public static void main(String[] args) {
        
        int d= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes: "));
        int option, cont=0;
        long cedula;
        String carrera, nombre, apellido;
        float ing, esp, mat, bio, promedio;
        Pila Materias= new Pila(4);
        
        ColaLista C1 = new ColaLista(d);
        
        do{
            option= Integer.parseInt(JOptionPane.showInputDialog(null, "1. Ingresar estudiante.\n"
                                                                    +  "2. Borrar.\n"
                                                                    +  "3. Ordenar Cola por cédula.\n"
                                                                    +  "4. Mostrar Cola.\n"
                                                                    +  "5. Modificar datos.\n"
                                                                    +  "6. Salir", "Menú principal",2));
            
            switch (option) {
                case 1: 
                        cedula =Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cédula: "));
                        carrera =JOptionPane.showInputDialog(null, "Ingrese carrera: ");
                        nombre =JOptionPane.showInputDialog(null, "Ingrese nombre: ");
                        apellido =JOptionPane.showInputDialog(null, "Ingrese apellido: ");

                        ing=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la nota definitiva de inglés: "));
                        mat=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la nota definitiva de matemáticas: "));
                        bio=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la nota definitiva de biología: "));
                        esp=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la nota definitiva de español: "));

                        C1.Encolar(cedula, carrera, nombre, apellido, ing,mat,bio,esp);
                        C1.MostrarCola();  
                    break;
                case 2:
                    C1.Desencolar();
                    break;
                case 3:
                    C1.OrdenarCC();
                    break;
                case 4:
                    C1.MostrarCola();
                    break;
                case 5:
                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del estudiante: "));
                    C1.BuscarDato(d);
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta");
            }
            
        } while (option!=6);
    } 
}

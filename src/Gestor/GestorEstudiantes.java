package Gestor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import Gestor.Estudiante;


public class GestorEstudiantes {
    public static void main(String[] args) {
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Editar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la identificación del estudiante: ");
                    String identificacion = scanner.nextLine();
                    System.out.print("Ingrese el curso del estudiante: ");
                    String curso = scanner.nextLine();
                    Estudiante estudiante = new Estudiante(nombre, identificacion, curso);
                    listaEstudiantes.add(estudiante);
                    System.out.println("Estudiante agregado correctamente.");
                    break;
                case 2:
                    System.out.println("Lista de estudiantes:");
                    for (Estudiante e : listaEstudiantes) {
                        System.out.println("Nombre: " + e.nombre + ", Identificación: " + e.identificacion + ", Curso: " + e.curso);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la identificación del estudiante que desea editar: ");
                    String idEditar = scanner.nextLine();
                    Iterator<Estudiante> iterator = listaEstudiantes.iterator();
                    boolean encontrado = false;
                    while (iterator.hasNext()) {
                        Estudiante est = iterator.next();
                        if (est.identificacion.equals(idEditar)) {
                            System.out.print("Ingrese el nuevo nombre del estudiante: ");
                            est.nombre = scanner.nextLine();
                            System.out.print("Ingrese el nuevo curso del estudiante: ");
                            est.curso = scanner.nextLine();
                            System.out.println("Estudiante editado correctamente.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la identificación del estudiante que desea eliminar: ");
                    String idEliminar = scanner.nextLine();
                    iterator = listaEstudiantes.iterator();
                    while (iterator.hasNext()) {
                        Estudiante est = iterator.next();
                        if (est.identificacion.equals(idEliminar)) {
                            iterator.remove();
                            System.out.println("Estudiante eliminado correctamente.");
                            encontrado = true;
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }
}

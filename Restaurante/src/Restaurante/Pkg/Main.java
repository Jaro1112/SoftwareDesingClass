package Restaurante.Pkg;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
	
		public static void main(String[] args) {
			System.out.print("\u001B[0m"); 			
			System.out.print("\u001B[42m");
			
			System.out.println("Bienvenido al Sistema de Gestión de Ingredientes del Restaurante");
			 
			System.out.print("\u001B[0m"); 
			 
		        System.out.println("---------------------------------------------------------------");
	        	        
			Scanner scanner = new Scanner(System.in);
	        List<Ingrediente> listaIngredientes = new ArrayList<>();
	        
	        System.out.print("\u001B[30m");
	        System.out.print("\u001B[46m");

	        
	        System.out.println("		  Menu                   ");
	        System.out.println("		                 ");
            System.out.println("| 1. Ver ingredientes		|");
            System.out.println("| 2. Editar ingredientes	|");
            System.out.println("| 3. Eliminar ingredientes	|");
            System.out.println("| 4. Agregar ingrediente	|");
            System.out.println("| 5. Salir del programa		|");
            System.out.print("  | Seleccione una opción: ");
          
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
	        while (opcion != 5) {

	            switch (opcion) {
	                case 1:
	                	 System.out.println("");
	                     System.out.print("\u001B[42m");
	                	 System.out.println("Lista de Ingredientes:");
	                	 System.out.print("\u001B[0m"); 
	                     System.out.println("-----------------------------------------------");
	                     for (Ingrediente ingrediente : listaIngredientes) {
	                    	 System.out.print("\u001B[30m");
	                    	 System.out.print("\u001B[42m");
	                         System.out.println(ingrediente.toString());
	                         System.out.print("\u001B[0m");
	                         System.out.println("---------------------------------------------");
	                    }
	                    break;
	                case 2:
	                	System.out.print("Ingrese el nombre del ingrediente que desea editar: ");
	                    String nombreEditar = scanner.nextLine();
	                    Ingrediente ingredienteAEditar = null;

	                    for (Ingrediente ingrediente : listaIngredientes) {
	                        if (ingrediente.getNombre().equalsIgnoreCase(nombreEditar)) {
	                            ingredienteAEditar = ingrediente;
	                            break;
	                        }
	                    }

	                    if (ingredienteAEditar != null) {
	                        System.out.println("Editando ingrediente: " + ingredienteAEditar.getNombre());
	                        System.out.print("Nuevo nombre: ");
	                        String nuevoNombre = scanner.nextLine();
	                        ingredienteAEditar.setNombre(nuevoNombre);

	                        System.out.print("Nueva unidad: ");
	                        String nuevaUnidad = scanner.nextLine();
	                        ingredienteAEditar.setUnidad(nuevaUnidad);

	                        System.out.print("Nuevo valor por unidad: ");
	                        double nuevoValor = scanner.nextDouble();
	                        scanner.nextLine();
	                        ingredienteAEditar.setValorUnidad(nuevoValor);

	                        System.out.print("Nuevo proveedor (nombre del proveedor): ");
	                        String nuevoProveedor = scanner.nextLine();
	                        Proveedor proveedor = Proveedor.valueOf(nuevoProveedor.toUpperCase());
	                        ingredienteAEditar.setSitioCompra(proveedor);

	                        System.out.print("Nuevas calorías por unidad: ");
	                        double nuevasCalorias = scanner.nextDouble();
	                        scanner.nextLine();
                            
	                        System.out.println("");
	                        System.out.print("\u001B[42m");
	                        System.out.println("Ingrediente editado con éxito.");
	                        System.out.print("\u001B[0m"); 
	                        System.out.println("");
	                    	} else {	                    	
	            		        System.out.println("");
	                    		System.out.print("\u001B[41m");	
	                    		System.out.println("No se encontró el ingrediente con el nombre proporcionado.");
	                    		System.out.print("\u001B[0m"); 
	                    		System.out.println("");
	                    			}	                        	                    
	                    break;
	                case 3:
	                    System.out.print("Ingrese el nombre del ingrediente que desea eliminar: ");
	                    String nombreEliminar = scanner.nextLine();
	                    Ingrediente ingredienteAEliminar = null;
	                    for (Ingrediente ingrediente : listaIngredientes) {
	                        if (ingrediente.getNombre().equalsIgnoreCase(nombreEliminar)) {
	                            ingredienteAEliminar = ingrediente;
	                            break;
	                        }
	                    }
	                    if (ingredienteAEliminar != null) {
	                        listaIngredientes.remove(ingredienteAEliminar);
	                        System.out.println("Ingrediente eliminado con éxito.");
	                    } else {
	                    	System.out.println("");
	                    	System.out.print("\u001B[41m");
	                        System.out.println("No se encontró el ingrediente con el nombre proporcionado.");
	                        System.out.print("\u001B[0m"); 
                    		System.out.println("");
	                    }
	                    break;
	                case 4:
	                	System.out.print("Ingrese el nombre del nuevo ingrediente: ");
	                    String nombreNuevo = scanner.nextLine();
	                    System.out.print("Ingrese la unidad del nuevo ingrediente: ");
	                    String unidadNueva = scanner.nextLine();
	                    System.out.print("Ingrese el valor por unidad del nuevo ingrediente (Kg): ");
	                    double valorNuevo = scanner.nextDouble();
	                    scanner.nextLine(); // espacio
	                    System.out.print("Ingrese el proveedor del nuevo ingrediente (nombre del proveedor): ");
	                    String proveedorNuevo = scanner.nextLine();
	                    System.out.print("Ingrese las calorías por unidad del nuevo ingrediente: ");
	                    double caloriasNuevas = scanner.nextDouble();
	                    scanner.nextLine(); // espacio

	                    Proveedor proveedor = Proveedor.valueOf(proveedorNuevo.toUpperCase());

	                    Ingrediente nuevoIngrediente = new Ingrediente(nombreNuevo, unidadNueva, valorNuevo, proveedor, caloriasNuevas);
	                    listaIngredientes.add(nuevoIngrediente);
	                    
	                    System.out.println("");
                        System.out.print("\u001B[42m");
	                    System.out.println("Ingrediente agregado con éxito.");
	                    System.out.print("\u001B[0m"); 
	                    System.out.println("");
	                    break;
	                case 5:
	                	System.out.print("\u001B[41m");
	                	System.out.println("Cerrando aplicacion. ¡Hasta luego!");
	                    scanner.close(); // Cerrar 
	                    System.exit(0);
	                    break;
	                default:
	                	System.out.print("\u001B[41m");
	                    System.out.println("Opción no válida.");
	            }
	            System.out.print("\u001B[30m");
	            System.out.print("\u001B[46m");
	            //Orden menu
	            System.out.println("		  Menu                   ");
		        System.out.println("		                 ");
	            System.out.println("| 1. Ver ingredientes		|");
	            System.out.println("| 2. Editar ingredientes	|");
	            System.out.println("| 3. Eliminar ingredientes	|");
	            System.out.println("| 4. Agregar ingrediente	|");
	            System.out.println("| 5. Salir del programa		|");
	            System.out.print("  | Seleccione una opción: ");

	            opcion = scanner.nextInt();
	            scanner.nextLine();
	        }
	        
		}
}
	    	               	        
               	        

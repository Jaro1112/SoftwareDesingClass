package Restaurante.Pkg;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
		public static void main(String[] args) {
			
            System.out.print("\u001B[0m");
			
			System.out.print("\u001B[102m");
			
			System.out.println("Bienvenido al Sistema de Gestión de Ingredientes del Restaurante");
			 
			System.out.print("\u001B[0m"); 
			 
		    System.out.println("---------------------------------------------------------------");
	        	        
		        Scanner scanner = new Scanner(System.in);
		        List<Ingrediente> listaIngredientes = new ArrayList<>();
		        List<Receta> listaRecetas = new ArrayList<>();
		        Receta recetaImprimible = new Receta("Receta Imprimible", 20, 4, List.of("Ingrediente1", "Ingrediente2"), "Descripción de la receta imprimible");
	        	        
	        Receta receta1 = new Receta("Carne Con Papas", 30, 2, List.of("Carne", "Papas"), "Carne asada con papa frita");
	        Receta receta2 = new Receta("Lasanya", 45, 4, List.of("Pasta", "Pollo"), "Lasanya de pollo");
	        listaRecetas.add(receta1);
	        listaRecetas.add(receta2);
	        
	        System.out.print("\u001B[30m");
	        System.out.print("\u001B[106m");
	        

	        
	        System.out.println("		  Menu                   ");
	        System.out.println("		                 ");
            System.out.println("| 1. Ver ingredientes		|");
            System.out.println("| 2. Editar ingredientes	|");
            System.out.println("| 3. Eliminar ingredientes	|");
            System.out.println("| 4. Agregar ingrediente	|");
            System.out.println("| 5. Salir del programa		|");
            System.out.println("| 6. Verificando Recetas	|");
            System.out.println("| 7. editar Recetas      	|");
            System.out.println("| 8. Agregar Recetas	    |");
            System.out.println("| 9. Eliminar Recetas	    |");
            System.out.print("  | Seleccione una opción: \n");
          
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
	        while (opcion != 5) {

	            switch (opcion) {
	                case 1:
				    //Ver Ingredientes
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
				    // Editar Ingredientes
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
				//Eliminar Ingredientes    
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
				    //Agregar ingrediente
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
	                case 6:
				    //RECETAS DISPONIBLES
	                	 System.out.println("Verificando recetas disponibles...");

	                	    if (listaRecetas.isEmpty()) {
	                	        System.out.println("No hay recetas disponibles.");
	                	        
	                	    }else {	                	    	
	                	        for (Receta receta : listaRecetas){	                	        	
	                	        		System.out.print("\u001B[42m");
		                	            System.out.println(receta);
		                	            System.out.print("\u001B[0m");
		                	            System.out.println("----------------------------------------");
	                	        
	                	            }   }break;  
	                case 7:
	                    // Editar Recetas
	                    System.out.print("Ingrese el nombre de la receta que desea editar: ");
	                    String nombreRecetaEditar = scanner.nextLine();
	                    Receta recetaAEditar = null;

	                    for (Receta receta : listaRecetas) {
	                        if (receta.getNombreReceta().equalsIgnoreCase(nombreRecetaEditar)) {
	                            recetaAEditar = receta;
	                            break;
	                        }
	                    }

	                    if (recetaAEditar != null) {
	                        System.out.println("Editando receta: " + recetaAEditar.getNombreReceta());
	                        System.out.print("Nuevo nombre de receta: ");
	                        String nuevoNombreReceta = scanner.nextLine();
	                        recetaAEditar.setNombreReceta(nuevoNombreReceta);

	                        System.out.print("Nuevo tiempo de preparación en minutos: ");
	                        double nuevoTiempoPreparacion = scanner.nextDouble();
	                        scanner.nextLine();
	                        recetaAEditar.setTiempoPreparacion(nuevoTiempoPreparacion);

	                        System.out.print("Nuevo número de personas: ");
	                        int nuevoNumeroPersonas = scanner.nextInt();
	                        scanner.nextLine();
	                        recetaAEditar.setNumeroPersonas(nuevoNumeroPersonas);

	                        System.out.print("Nueva descripción de la receta: ");
	                        String nuevaDescripcionReceta = scanner.nextLine();
	                        recetaAEditar.setDescripcion(nuevaDescripcionReceta);

	                        // Puedes dejar la lista de ingredientes como está o implementar una lógica similar a la de agregar ingredientes.

	                        System.out.println("");
	                        System.out.print("\u001B[42m");
	                        System.out.println("Receta editada con éxito.");
	                        System.out.print("\u001B[0m");
	                        System.out.println("");
	                    } else {
	                        System.out.println("");
	                        System.out.print("\u001B[41m");
	                        System.out.println("No se encontró la receta con el nombre proporcionado.");
	                        System.out.print("\u001B[0m");
	                        System.out.println("");
	                    }
	                    break;
	                case 8:
	                	// Agregar Receta
	                    System.out.print("Ingrese el nombre de la nueva receta: ");
	                    String nuevoNombreReceta = scanner.nextLine();
	                    System.out.print("Ingrese el tiempo de preparación en minutos: ");
	                    double nuevoTiempoPreparacion = scanner.nextDouble();
	                    scanner.nextLine();
	                    System.out.print("Ingrese el número de personas: ");
	                    int nuevoNumeroPersonas = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.print("Ingrese la descripción de la receta: ");
	                    String nuevaDescripcionReceta = scanner.nextLine();

	                    // Crear una nueva lista de ingredientes para la receta
	                    List<String> ingredientesReceta = new ArrayList<>();

	                    // Permitir al usuario agregar hasta dos ingredientes a la receta
	                    for (int i = 0; i < 2; i++) {
	                        System.out.print("Ingrese un ingrediente (" + (i + 1) + "/2): ");
	                        String nuevoIngrediente1 = scanner.nextLine();

	                        // Agregar el ingrediente a la lista de ingredientes de la receta
	                        ingredientesReceta.add(nuevoIngrediente1);
	                    }

	                    // Crear la nueva receta con los ingredientes
	                    Receta nuevaReceta = new Receta(nuevoNombreReceta, nuevoTiempoPreparacion, nuevoNumeroPersonas, ingredientesReceta, nuevaDescripcionReceta);
	                    listaRecetas.add(nuevaReceta);

	                    System.out.println("");
	                    System.out.print("\u001B[42m");
	                    System.out.println("Receta agregada con éxito.");
	                    System.out.print("\u001B[0m");
	                    System.out.println("");
	                    break;
	                case 9:
	                    // Eliminar Receta
	                    System.out.print("Ingrese el nombre de la receta que desea eliminar: ");
	                    String nombreRecetaEliminar = scanner.nextLine();
	                    Receta recetaAEliminar = null;

	                    for (Receta receta : listaRecetas) {
	                        if (receta.getNombreReceta().equalsIgnoreCase(nombreRecetaEliminar)) {
	                            recetaAEliminar = receta;
	                            break;
	                        }
	                    }

	                    if (recetaAEliminar != null) {
	                        listaRecetas.remove(recetaAEliminar);
	                        System.out.println("Receta eliminada con éxito.");
	                    } else {
	                        System.out.println("");
	                        System.out.print("\u001B[41m");
	                        System.out.println("No se encontró la receta con el nombre proporcionado.");
	                        System.out.print("\u001B[0m");
	                        System.out.println("");
	                    }
	                    break;   
	                default:
	                    System.out.print("\u001B[41m");
	                    System.out.println("Opción no válida.");
	                    break;
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
	            System.out.println("| 6. Verificando Recetas	|");
	            System.out.println("| 7. editar Recetas      	|");
	            System.out.println("| 8. Agregar Recetas	    |");
	            System.out.println("| 9. Eliminar Recetas	    |");
	            System.out.print("  | Seleccione una opción: \n");

	            opcion = scanner.nextInt();
	            scanner.nextLine();
	        }
	        
		}
}
	    	               	        
               	        

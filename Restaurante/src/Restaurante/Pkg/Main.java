package Restaurante.Pkg;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
		public static void main(String[] args) {
			
	        Ingrediente ingrediente1 = new Ingrediente(" Leche", " 1 Litro", 12000.0, Proveedor.COLANTA, 558.0);
	        Ingrediente ingrediente2 = new Ingrediente(" Carne de res", " 1 Kilogramo", 13000.0, Proveedor.CARNESSABASTIAN, 156.0);

	        Scanner sc = new Scanner(System.in);
	       	System.out.println("1- Editar receta 2- Eliminar Receta 3- Continuar");
	       	String eleccion = sc.nextLine();
			//Para hacer participar a los usuarios y no solo al programador
	        switch (eleccion){
	        	case "1":	
	        		System.out.println("Editar ingrediente 1, 2 para eliminar, 3 agregar ingrediente, 4 para ver los ingredientes");
	        		String cual = sc.nextLine();
	        		switch(cual) {
	        			case "1":
	        			
	        			break;
	        			case "2":
	        				
	        			break;
	        		}
	            break;
	        		case "2":
	        			System.out.println("Editar ingrediente 1 o 2");
		        		String cual2 = sc.nextLine();
		        		switch(cual2) {
		        			case "1":
		        				ingrediente1 = null;
		        				break;
		        			case "2":
		        				ingrediente2 = null;
		        				break;		        				
		        		case"3":
		        		Ingrediente ingrediente3 = new Ingrediente(" Carne de cerdo", "1 Kilogramo", 13000.0, Proveedor.CARNESSABASTIAN, 180.0);
	        default:
	        	List<String> listaIngredientes = new ArrayList<>();
		        listaIngredientes.add(ingrediente1.getNombre());
		        listaIngredientes.add(ingrediente2.getNombre());

	        }
	        
/*	        	       
	        Receta receta1 = new Receta("Lasaña", 60.0, 4, listaIngredientes, "Una lasaña de carne");

	        
	        System.out.println("Receta:");
	        System.out.println(receta1);
	        System.out.println("\nIngredientes:");
	        System.out.println(ingrediente1);
	        System.out.println(ingrediente2);
	    	*/
	        }
		}
	#dsafasdf
}


package Restaurante.Pkg;

import java.util.List;

public class Receta {

		private String nombreReceta;
	    private double tiempoPreparacion;
	    private int numeroPersonas;
	    private List<String> listaIngredientes;
	    private String descripcion;

	    public Receta(String nombreReceta, double tiempoPreparacion, int numeroPersonas, List<String> listaIngredientes,
	            String descripcion) {
	        this.nombreReceta = nombreReceta;
	        this.tiempoPreparacion = tiempoPreparacion;
	        this.numeroPersonas = numeroPersonas;
	        this.listaIngredientes = listaIngredientes;
	        this.descripcion = descripcion;
	    }


	    public String getNombreReceta() {
	        return nombreReceta;
	    }

	    public void setNombreReceta(String nombreReceta) {
	        this.nombreReceta = nombreReceta;
	    }

	    public double getTiempoPreparacion() {
	        return tiempoPreparacion;
	    }

	    public void setTiempoPreparacion(double tiempoPreparacion) {
	        this.tiempoPreparacion = tiempoPreparacion;
	    }

	    public int getNumeroPersonas() {
	        return numeroPersonas;
	    }

	    public void setNumeroPersonas(int numeroPersonas) {
	        this.numeroPersonas = numeroPersonas;
	    }

	    public List<String> getListaIngredientes() {
	        return listaIngredientes;
	    }

	    public void setListaIngredientes(List<String> listaIngredientes) {
	        this.listaIngredientes = listaIngredientes;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }
	    
	    public String toString() {
	        return "Receta [nombreReceta=" + nombreReceta + ", tiempoPreparacion=" + tiempoPreparacion + " Minutos" + ", numeroPersonas="
	                + numeroPersonas + ", listaIngredientes=" + listaIngredientes + ", descripcion=" + descripcion + ", Total calorias=" + sumcalorias + "]";
	    }
	    
	    int sumcalorias = 558+156;
}



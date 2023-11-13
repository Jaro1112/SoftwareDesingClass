package Restaurante.Pkg;

public class Ingrediente {
	    //atributos
	    private String nombre;
	    private int unidad;
	    private double valorUnidad;
	    private Proveedor sitioCompra;
	    private double caloriasUnidad;
	    //constructor
	    public Ingrediente(String nombre, int unidadNueva, double valorUnidad, Proveedor sitioCompra, double caloriasUnidad) {
	        this.nombre = nombre;
	        this.unidad = unidadNueva;
	        this.valorUnidad = valorUnidad;
	        this.sitioCompra = sitioCompra;
	        this.caloriasUnidad = caloriasUnidad;
	    }
	    //metodos
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getUnidad() {
	        return unidad;
	    }

	    public void setUnidad(int nuevaUnidad) {
	        this.unidad = nuevaUnidad;
	    }

	    public double getValorUnidad() {
	        return valorUnidad;
	    }

	    public void setValorUnidad(double valorUnidad) {
	        this.valorUnidad = valorUnidad;
	    }

	    public Proveedor getSitioCompra() {
	        return sitioCompra;
	    }

	    public void setSitioCompra(Proveedor sitioCompra) {
	        this.sitioCompra = sitioCompra;
	    }

	    public double getCaloriasUnidad() {
	        return caloriasUnidad;
	    }

	    public void setCaloriasUnidad(double caloriasUnidad) {
	        this.caloriasUnidad = caloriasUnidad;
	    }

	    public String toString() {
	        return "Ingrediente [nombre=" + nombre + ", cantidad=" + unidad + ", valorUnidad=" + valorUnidad + " COP"
	                + ", sitioCompra=" + sitioCompra + ", caloriasUnidad=" + caloriasUnidad + "]";
	    
		}
}




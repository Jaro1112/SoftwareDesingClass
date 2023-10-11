package Restaurante.Pkg;

public class Ingrediente {
	    //atributos
	    private String nombre;
	    private String unidad;
	    private double valorUnidad;
	    private Proveedor sitioCompra;
	    private double caloriasUnidad;
	    //constructor
	    public Ingrediente(String nombre, String unidad, double valorUnidad, Proveedor sitioCompra, double caloriasUnidad) {
	        this.nombre = nombre;
	        this.unidad = unidad;
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

	    public String getUnidad() {
	        return unidad;
	    }

	    public void setUnidad(String unidad) {
	        this.unidad = unidad;
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
	        return "Ingrediente [nombre=" + nombre + ", unidad=" + unidad + ", valorUnidad=" + valorUnidad + " COP"
	                + ", sitioCompra=" + sitioCompra + ", caloriasUnidad=" + caloriasUnidad + "]";
	    
		}
}


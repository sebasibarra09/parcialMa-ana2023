package ar.edu.unlam.pb2.Parcial01;

public class Producto implements Vendible{
	
	private Integer puntoDeReposicion;
	private Integer codigo;
	private String nombre;
	private Double precio;
	
	
	public Producto(Integer codigo, String nombre, Double precio, Integer puntoDeReposicion) {
		this.puntoDeReposicion =puntoDeReposicion;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	
	@Override
	public Integer getCodigo() {
		return this.codigo;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public Double getPrecio() {
		return this.precio;
	}

	// TODO: Completar con los getters y setters necesarios
	
}

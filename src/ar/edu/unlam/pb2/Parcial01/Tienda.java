package ar.edu.unlam.pb2.Parcial01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Tienda {

	/**
	 * En esta ocasion deberemos resolver un producto software que nos permita
	 * administrar la venta de productos o servicios de nuestra tienda. Venderemos
	 * entonces, productos como mouse o teclados y servicios como el soporte tecnico
	 * a domicilio. Sabemos que la tienda cuenta con items Vendibles que pueden ser
	 * del tipo Producto o Servicio. Ademas, podemos registrar el stock de los
	 * productos, los clientes a quienes les vendemos algun producto o servicio, las
	 * ventas y los vendedores de la tienda. Antes de realizar alguna operacion, se
	 * debera obtener el elemento correspondiente de las colecciones. Ejemplo: Si
	 * quisiera realizar alguna operacion con un cliente, el mismo debe obtenerse de
	 * la coleccion de clientes.
	 * 
	 * Cada Venta contiene renglones los cuales representa a los productos o
	 * servicios que se incluyen en la misma. Tambien cuenta con el Cliente y
	 * Vendedor que participan en la Venta. Cuando agregamos un vendible a una
	 * venta, lo haremos con 1 unidad. En una version posterior, admitiremos
	 * cantidades variables.
	 * 
	 * Cada Item debe compararse por nombre y precio, en caso de ser necesario.
	 * Recordar que los items deben ser Vendibles.
	 * 
	 */

	private String cuit;
	private String nombre;
	private Set<Vendible> vendibles;
	private Map<Producto, Integer> stock;
	private List<Cliente> clientes;
	private Set<Venta> ventas;
	private Set<Vendedor> vendedores;

	public Tienda(String cuit, String nombre) {
		this.cuit = cuit;
		this.nombre= nombre;
		this.vendibles = new HashSet<>();
		this.stock = new TreeMap<>();
		this.clientes = new ArrayList<>();
		this.ventas = new HashSet<>();
		this.vendedores = new HashSet<>();
	}

	// TODO: Completar con los getters y setters necesarios

	public Vendible getVendible(Integer codigo) {
		// TODO: Obtiene un producto o servicio de la coleccion de vendibles utilizando
		// el codigo. En caso de no existir devuelve null.
		for (Vendible vendible : vendibles) {
			if (vendible.getCodigo().equals(codigo)) {
				return vendible;
			}
		}
		return null;
	}

	public void agregarProducto(Producto producto) {
		this.agregarProducto(producto, 0);
	}

	public void agregarProducto(Producto producto, Integer stockInicial) {
		// TODO: Agrega un producto a la coleccion de vendibles y pone en la coleccion
		// de stocks al producto con su stock inicial
		vendibles.add(producto);
		stock.put(producto, stockInicial);
	}

	public void agregarServicio(Servicio servicio) {
		// TODO: Agrega un servicio a la coleccion de vendibles
		vendibles.add(servicio);
	}

	public Integer getStock(Producto producto) {
		return stock.get(producto);
	}

	public void agregarStock(Producto producto, Integer incremento){
		  if(stock.containsKey(producto)) {
		        stock.put(producto, stock.get(producto) + incremento);
		  }
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void agregarVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);
	}

	public void agregarVenta(Venta venta) throws VendedorDeLicenciaException {
		// TODO: Agrega una venta a la coleccion correspondiente. En caso de que el
		// vendedor este de licencia, arroja una
		// VendedorDeLicenciaException
		if (venta.getVendedor().isDeLicencia()) {
			throw new VendedorDeLicenciaException();
		}
		ventas.add(venta);
		
	}

	public Producto obtenerProductoPorCodigo(Integer codigo) {
		// TODO: Obtiene un producto de los posibles por su codigo. En caso de no
		// encontrarlo se debera devolver null
		for (Map.Entry<Producto, Integer> entry : stock.entrySet()) {
            if (entry.getValue().equals(codigo)) {
                return entry.getKey();
            }
        }
        return null;
	}

	public void agregarProductoAVenta(String codigoVenta, Producto producto) throws VendibleInexistenteException {

		// TODO: Agrega un producto a una venta. Si el vendible no existe (utilizando su
		// codigo), se debe lanzar una VendibleInexistenteException
		// Se debe actualizar el stock en la tienda del producto que se agrega a la
		// venta
		if (obtenerProductoPorCodigo(producto.getCodigo()) == null) {
			throw new VendibleInexistenteException();
		}
		Venta venta = buscarVentasPorCodigo(codigoVenta);
		venta.agregarRenglon(producto, 1);
		agregarStock(producto, -1);
	}
	
	public Venta buscarVentasPorCodigo(String codigoVenta) {
		for (Venta vent : ventas) {
			if (vent.getCodigo().equals(codigoVenta)) {
				return vent;
			}
		}
		return null;
	}

	public void agregarServicioAVenta(String codigoVenta, Servicio servicio) {
		// TODO: Agrega un servicio a la venta. Recordar que los productos y servicios
		// se traducen en renglones
		Venta venta = buscarVentasPorCodigo(codigoVenta);
		venta.agregarRenglon(servicio, 1);
	}

	public List<Producto> obtenerProductosCuyoStockEsMenorOIgualAlPuntoDeReposicion() {
		// TODO: Obtiene una lista de productos cuyo stock es menor o igual al punto de
		// reposicion. El punto de reposicion, es un valor que
		// definimos de manera estrategica para que nos indique cuando debemos reponer
		// stock para no quedarnos sin productos
		return null;
	}

	public List<Cliente> obtenerClientesOrdenadosPorRazonSocialDescendente() {
		// TODO: obtiene una lista de clientes ordenados por su razon social de manera
		// descendente
		return null;
	}

	public Map<Vendedor, Set<Venta>> obtenerVentasPorVendedor() {
		// TODO: Obtiene un mapa que contiene las ventas realizadas por cada vendedor.
		return null;
	}

	public Double obtenerTotalDeVentasDeServicios() {
		// TODO: obtiene el total acumulado de los vendibles que son servicios incluidos
		// en todas las ventas.
		// Si una venta incluye productos y servicios, solo nos interesa saber el total
		// de los servicios
		return null;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Vendible> getVendibles() {
		return vendibles;
	}

	public void setVendibles(Set<Vendible> vendibles) {
		this.vendibles = vendibles;
	}

	public Map<Producto, Integer> getStock() {
		return stock;
	}

	public void setStock(Map<Producto, Integer> stock) {
		this.stock = stock;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Set<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

	public Set<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(Set<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}
}

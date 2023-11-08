package ar.edu.unlam.pb2.Parcial01;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TiendaTest {

	/**
	 * Resolver los siguientes tests
	 * @throws VendedorDeLicenciaException 
	 */

	@Test (expected = VendedorDeLicenciaException.class)
	public void queAlIntentarAgregarUnaVentaParaUnVendedorDeLicenciaSeLanceUnaVendedorDeLicenciaException() throws VendedorDeLicenciaException {
		Vendedor jose = new Vendedor("40350321", "Josecito");
		jose.setDeLicencia(true);
		Tienda kiosko = new Tienda("123581", "kioskito");
		Cliente pedro = new Cliente("12", "unico");
		Venta venta = new Venta("15", pedro, jose);
		kiosko.agregarVendedor(jose);
		kiosko.agregarVenta(venta);
		assertTrue(jose.isDeLicencia());
	}

	@Test
	public void queAlIntentarAgregarUnVendibleInexistenteAUnaVentaSeLanceUnaVendibleInexistenteException() {
	}

	@Test
	public void queSePuedaObtenerUnaListaDeProductosCuyoStockEsMenorOIgualAlPuntoDeReposicion() {
	}

	@Test
	public void queSePuedaObtenerUnSetDeClientesOrdenadosPorRazonSocialDescendente() {
	}

	@Test
	public void queSePuedaObtenerUnMapaDeVentasRealizadasPorCadaVendedor() {
		// TODO: usar como key el vendedor y Set<Venta> para las ventas
	}

	@Test
	public void queSePuedaObtenerElTotalDeVentasDeServicios() {
	}

	@Test
	public void queAlRealizarLaVentaDeUnProductoElStockSeActualiceCorrectamente() {
	}
}

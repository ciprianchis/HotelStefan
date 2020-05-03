package testing;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;

import principal.IoDatos;
import principal.OperacionHabitacion;
import principal.Pago;
import principal.Reservar;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MyRunner.class)
public class RunListenerTest {

	OperacionHabitacion opHab;
	Reservar reserva;
	Pago pago;

	@BeforeAll
	void setUp() throws Exception {
		opHab = new OperacionHabitacion();
		reserva = new Reservar();
		pago = new Pago();

	}

	@Test
	public void testDisponibilidadHabitaciones() {
		assertEquals(true, opHab.comprobarHabitacionTest(0));
	}

	@Test
	public void testDisponibilidadHabitaciones_2() {
		try {
			opHab.comprobarHabitacion(60);
			assertFalse(false);
			// De esta manera si no hay excepción salta a false
		} catch (IndexOutOfBoundsException e) {
			assertFalse(true);
		}

	}

	@Test
	@Ignore
	public void testValorLimiteFecha() {
		assertEquals(true, reserva.comprobarMesTest(2002, 12, 31));
	}

	@Test
	@Ignore
	public void testValorLimiteFecha_2() {
		assertEquals(false, reserva.comprobarMesTest(1900, 2, 29));
	}

	@Test
	@Ignore
	public void testValorLimiteFecha_3() {
		assertEquals(false, reserva.comprobarMesTest(2003, 2, 29));
	}

	@Test
	public void testComprobacionUsuario() {
		assertEquals(true, IoDatos.comprobarUser("Borja", "12345"));
	}

	@Test
	public void testComprobacionUsuario_2() {
		assertEquals(false, IoDatos.comprobarUser("Iván", "001122"));
	}

	@Test
	public void testComprobacionPago() throws java.lang.NullPointerException {
		assertEquals(true, pago.testComprobacionNumeroTarjetaYcvc("1234 1234 1234 1234", "123"));
	}

	@Test
	public void testComprobacionPago_2() {
		assertEquals(false, pago.testComprobacionNumeroTarjetaYcvc("1234123412341234", "123"));
	}

	@Test
	public void testComprobacionPago_3() {
		assertEquals(false, pago.testComprobacionNumeroTarjetaYcvc("1234 1234 1234 123j", "123"));
	}

	@Test
	public void testComprobacionPago_4() {
		assertEquals(false, pago.testComprobacionNumeroTarjetaYcvc("1234 1234 1234 1234", "1j3"));
	}

}

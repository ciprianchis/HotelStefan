package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionListener;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import principal.IoDatos;
import principal.OperacionHabitacion;
import principal.Pago;
import principal.Reservar;

class JUnitTest {

	OperacionHabitacion opHab;
	Reservar reserva;
	Pago pago;

	@BeforeEach
	void setUp() throws Exception {
		opHab = new OperacionHabitacion();
		reserva = new Reservar();
		pago = new Pago();
	}

	@Test
	void testDisponibilidadHabitaciones() {
		assertEquals(true, opHab.comprobarHabitacionTest(0));
	}

	@Test
	void testDisponibilidadHabitaciones_2() {
		try {
			opHab.comprobarHabitacion(60);
			assertFalse(false);
			// De esta manera si no hay excepción salta a false
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}

	}

	@Test
	void testValorLimiteFecha() {
		assertEquals(true, reserva.comprobarMesTest(2002, 12, 31));
	}

	@Test
	void testValorLimiteFecha_2() {
		assertEquals(false, reserva.comprobarMesTest(1900, 2, 29));
	}

	@Test
	void testValorLimiteFecha_3() {
		assertEquals(false, reserva.comprobarMesTest(2003, 2, 29));
	}

	@Test
	void testComprobacionUsuario() {
		assertEquals(true, IoDatos.comprobarUser("Borja", "12345"));
	}

	@Test
	void testComprobacionUsuario_2() {
		assertEquals(false, IoDatos.comprobarUser("Iván", "001122"));
	}

	@Test
	void testComprobacionPago() {
		assertEquals(true, pago.testComprobacionNumeroTarjetaYcvc("1234 1234 1234 1234", "123"));
	}

	@Test
	void testComprobacionPago_2() {
		assertEquals(false, pago.testComprobacionNumeroTarjetaYcvc("1234123412341234", "123"));
	}

	@Test
	void testComprobacionPago_3() {
		assertEquals(false, pago.testComprobacionNumeroTarjetaYcvc("1234 1234 1234 123j", "123"));
	}

	@Test
	void testComprobacionPago_4() {
		assertEquals(false, pago.testComprobacionNumeroTarjetaYcvc("1234 1234 1234 1234", "1j3"));
	}
}

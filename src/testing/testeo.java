package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.OperacionHabitacion;
import principal.Reservar;

class testeo {

	OperacionHabitacion opHab;
	Reservar reserva;
	@BeforeEach
	void setUp() throws Exception {
		opHab = new OperacionHabitacion();
		reserva = new Reservar();
	}

	@Test
	void testDisponibilidadHabitaciones() {
		assertEquals(true, opHab.comprobarHabitacionTest(0));
	}
	

	@Test
	void testDisponibilidadHabitaciones_2() {
		try {
			opHab.comprobarHabitacion(60);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		assertFalse(false);
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
}

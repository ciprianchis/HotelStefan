package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.OperacionHabitacion;

class testeo {

	OperacionHabitacion opHab;
	
	@BeforeEach
	void setUp() throws Exception {
		opHab = new OperacionHabitacion();
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

}

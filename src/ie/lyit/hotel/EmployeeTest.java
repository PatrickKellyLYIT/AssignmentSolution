package ie.lyit.hotel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDateProbationEnds() {
		Employee e1 = new Employee ("Ms", "Lisa", "Simpson", "Springfield", 
						"0860987653", 20, 12, 1992, new Date( 1, 1, 2009), 25000);
		assertEquals(e1.getDateProbationEnds(30), new Date(31,1,2009));
	}
}
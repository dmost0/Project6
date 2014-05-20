import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagerHourlyWorkerTest {
	Company company;
	Manager m;
	Design d;
	@Before
	public void setUp() throws Exception {
		m = new Manager("doe","White",111,500.00 ); // Manager
		d = new Design("doe","Boop",244,14.00, 50); //Hourly worker
	}

	@After
	public void tearDown() throws Exception {
		company = null;
	}

	@Test
	public void testManagerHourlyWorker() {
		assertEquals(500.00, m.calculateWeeklyPay(), .001);
		assertEquals(770.00, d.calculateWeeklyPay(), .001);
	}

}

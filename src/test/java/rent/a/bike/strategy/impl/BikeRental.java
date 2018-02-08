package rent.a.bike.strategy.impl;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import rent.a.bike.exception.RentalException;
import rent.a.bike.strategy.RentalContext;

@RunWith(MockitoJUnitRunner.class)
public class BikeRental {
	
	RentalContext context;
	
	@Spy
	RentToFamily rentFamilySpy;	
	@Spy
	RentByDay rentByDaySpy;
	@Spy
	RentByHour rentByHourSpy;
	@Spy
	RentByWeek rentByWeekSpy;
	
	@Mock
	RentalContext contextMock;
	
	@Spy
	RentalContext contextSpy;
	
	@Mock
	RentByDay rentByDayMock;
		
	@Before
	public void setup() {
		context = new RentalContext();
	}
	
	@Test
	public void testByDayFee() throws RentalException {
		String rentOutput = rentByDaySpy.rent(); 
		assertEquals(rentOutput, String.format("You've been charged for a total of $%s for your %s bike rental", new Object[] {rentByDaySpy.getFee(), RentalSolution.RENTAL_TYPES.DAY}));
	}
	
	@Test
	public void testByHourFee() throws RentalException {
		String rentOutput = rentByHourSpy.rent(); 
		assertEquals(rentOutput, String.format("You've been charged for a total of $%s for your %s bike rental", new Object[] {rentByHourSpy.getFee(), RentalSolution.RENTAL_TYPES.HOUR}));
	}
	
	@Test
	public void testByWeekFee() throws RentalException {
		String rentOutput = rentByWeekSpy.rent(); 
		assertEquals(rentOutput, String.format("You've been charged for a total of $%s for your %s bike rental", new Object[] {rentByWeekSpy.getFee(), RentalSolution.RENTAL_TYPES.WEEK}));
	}
	
	@Test
	public void testRentalByDay() throws RentalException {
		contextMock.setStrategy(rentByDaySpy);
		doReturn(5.0).when(rentByDaySpy).getFee();
		
		assertEquals(5.0 , rentByDaySpy.getFee());
	}
	
	@Test
	public void dynamicRentalTest() throws RentalException {
		contextSpy.setStrategy(rentByDaySpy);		
		String rentOutput = contextSpy.doRent();
		assertEquals(rentOutput, String.format("You've been charged for a total of $%s for your %s bike rental", new Object[] {rentByDaySpy.getFee(), RentalSolution.RENTAL_TYPES.DAY}));
		
		contextSpy.setStrategy(rentByWeekSpy);
		rentOutput = contextSpy.doRent();
		assertEquals(rentOutput, String.format("You've been charged for a total of $%s for your %s bike rental", new Object[] {rentByWeekSpy.getFee(), RentalSolution.RENTAL_TYPES.WEEK}));
	}
	
	@Test
	public void testFeefamilyDiscount() throws RentalException {
		// fee : 20 / 60 / 5 
		rentFamilySpy.addRental(new RentByDay()).addRental(new RentByHour()).addRental(new RentByWeek());

		verify(rentFamilySpy, atLeast(3)).addRental(any());

		assertEquals(85 * 0.7 , rentFamilySpy.getFee());
	}
	
	@Test(expected=RentalException.class)
	public void testFamilyWrongNumberRentals() throws RentalException {
		rentFamilySpy.addRental(new RentByDay()).addRental(new RentByWeek());	
		rentFamilySpy.rent();
	}
	
	

}

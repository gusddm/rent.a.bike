package rent.a.bike.strategy;

import java.util.List;

import rent.a.bike.exception.RentalException;

public interface RentalStrategy {
	
	public enum RENTAL_TYPES {HOUR, DAY, WEEK, FAMILY}
	
	public String rent() throws RentalException;
	public List<RentalStrategy> getRentalList();
	public RentalStrategy addRental(RentalStrategy rental) throws RentalException;
	public RENTAL_TYPES getRentalType();
	public Double getFee();
}

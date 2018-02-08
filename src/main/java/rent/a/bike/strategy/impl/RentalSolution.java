package rent.a.bike.strategy.impl;

import java.util.ArrayList;
import java.util.List;

import rent.a.bike.exception.RentalException;
import rent.a.bike.strategy.RentalStrategy;

public abstract class RentalSolution implements RentalStrategy {
	
	private List<RentalStrategy> rentalList = new ArrayList<>();
	
	public String rent() throws RentalException {
		return String.format("You've been charged for a total of $%s for your %s bike rental", new Object[] {this.getFee(), this.getRentalType()});
	}
	
	@Override
	public RentalSolution addRental(RentalStrategy rental) throws RentalException {
		if(!RENTAL_TYPES.FAMILY.equals(rental.getRentalType())) {			
			this.rentalList.add(rental);
			return this;
		}
		throw new RentalException("You can't add a FAMILIY rental to another FAMILY rental type");
	}
	
	public List<RentalStrategy> getRentalList() {
		return this.rentalList;
	}
}
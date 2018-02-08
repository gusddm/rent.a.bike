package rent.a.bike.strategy.impl;

import rent.a.bike.exception.RentalException;
import rent.a.bike.strategy.RentalStrategy;

public class RentToFamily extends RentalSolution {
	
	private static double discount = 30.0;
	
	public String rent() throws RentalException {	
		if(getRentalList().size() < 3 || getRentalList().size() > 5) {
			throw new RentalException("To use this promotion, you need to purchase between 3 and 5 Rentals");
		}
		return super.rent();
	}

	@Override
	public RENTAL_TYPES getRentalType() {
		return RENTAL_TYPES.FAMILY;
	}

	//calculate total rental fee , applying a 30% discount
	@Override
	public Double getFee() {
		double fee = getRentalList()
						.stream()
						.map(RentalStrategy::getFee)
						.reduce(0.0, (feeA, feeB) -> feeA + feeB);
		return fee * (1 - (discount/100));
	}

}

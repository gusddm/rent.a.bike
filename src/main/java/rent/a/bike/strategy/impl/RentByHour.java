package rent.a.bike.strategy.impl;

public class RentByHour extends RentalSolution {
	
	private double fee = 5;

	@Override
	public RENTAL_TYPES getRentalType() {
		return RENTAL_TYPES.HOUR;
	}

	@Override
	public Double getFee() {
		return fee;
	}

}

package rent.a.bike.strategy.impl;

public class RentByDay extends RentalSolution {
	
	private double fee = 20;

	@Override
	public RENTAL_TYPES getRentalType() {
		return RENTAL_TYPES.DAY;
	}

	@Override
	public Double getFee() {
		return fee;
	}

}

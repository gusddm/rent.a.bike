package rent.a.bike.strategy.impl;

public class RentByWeek extends RentalSolution {
	
	private double fee = 60;

	@Override
	public RENTAL_TYPES getRentalType() {
		return RENTAL_TYPES.WEEK;
	}

	@Override
	public Double getFee() {
		return fee;
	}

}

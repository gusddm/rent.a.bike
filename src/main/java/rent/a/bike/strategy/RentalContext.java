package rent.a.bike.strategy;

import rent.a.bike.exception.RentalException;

public class RentalContext {
	
	private RentalStrategy strategy;

	public String doRent() throws RentalException {
		return strategy.rent();
	}

	public void setStrategy(RentalStrategy strategy) {
		this.strategy = strategy;
	}
}
package myException;

public class DonationAmountException extends Exception{
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage()
	{
		return "DonationAmountException:Donation amount field should be filled and should be positive value and greater than 0";
	}
}

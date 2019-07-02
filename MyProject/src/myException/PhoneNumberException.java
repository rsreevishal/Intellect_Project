package myException;

public class PhoneNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage()
	{
		return "PhoneNumberException:Phone number field should be filled and should contain 10 digit";
	}
}

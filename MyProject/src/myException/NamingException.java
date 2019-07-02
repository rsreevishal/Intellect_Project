package myException;

public class NamingException extends Exception{
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage()
	{
		return "NamingException:Name field should be filled and min 8 characters max 30 characters are allowed";
	}
}

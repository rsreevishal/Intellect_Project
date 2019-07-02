package myException;

public class EmptyFieldException extends Exception{
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage()
	{
		return "EmptyFieldException:fields should be filled";
	}
}

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myException.DonationAmountException;
import myException.EmptyFieldException;
import myException.NamingException;
import myException.PhoneNumberException;

@WebServlet(description = "handles the request, raise exception if any, and finally submit to the server", urlPatterns = { "/RequestHandler" })
public class RequestHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> errors;
    public RequestHandler() {
        super();
        errors = new ArrayList<>();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			handleException(request);
			RequestDispatcher rs = request.getRequestDispatcher("DataBaseHandler");
			rs.forward(request, response);
		}catch(Exception e)
		{
			try {
				response.getWriter().println(e.getMessage());;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	private void handleException(HttpServletRequest request) throws Exception
	{
		try {
			String temp;
			temp = request.getParameter("uname");
			EmptyFieldExceptionHandler(temp);
			if(temp.length()<8||temp.length()>30)
			{
				throw new NamingException();
			}
			temp = request.getParameter("uno");
			EmptyFieldExceptionHandler(temp);
			if(temp.length()!=10)
			{
				throw new PhoneNumberException();
			}
			temp = request.getParameter("damt");
			EmptyFieldExceptionHandler(temp);
			if(Integer.parseInt(temp)<1)
			{
				throw new DonationAmountException();
			}
			temp = request.getParameter("add");
			EmptyFieldExceptionHandler(temp);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	private void EmptyFieldExceptionHandler(String field) throws Exception
	{
		if(field == "")
				throw new EmptyFieldException();
	}
}

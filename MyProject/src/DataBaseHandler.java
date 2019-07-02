

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataBaseHandler")
public class DataBaseHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
    public DataBaseHandler() {
        super();
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/association",user="root",pswd="rsree112001";
			con = DriverManager.getConnection(url,user,pswd);
		}catch(Exception e){System.out.println(e);}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response)
	{
		String q = "insert into members values(?,?,?,?,?,?)";
		try{
			PreparedStatement st = con.prepareStatement(q);
			st.setString(1,request.getParameter("uname"));
			st.setString(2,request.getParameter("email"));
			st.setString(3,request.getParameter("uno"));
			st.setString(4,request.getParameter("add"));
			st.setString(5,request.getParameter("dtype"));
			st.setString(6,request.getParameter("damt"));
			st.executeUpdate();
		}catch(Exception e1){System.out.println(e1);}
	}
}

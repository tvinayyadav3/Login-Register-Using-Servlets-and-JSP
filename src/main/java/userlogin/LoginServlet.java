package userlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Connection con=null;
    public void init()
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javacon","root","Password");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter obj=response.getWriter();
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			obj.println("Hello");
			PreparedStatement st=con.prepareStatement("select * from users where username='"+username+"' and password='"+password+"' ");
//			obj.println("Login Successful");		
			ResultSet rs=st.executeQuery();
			 		
			if(rs.next()) {
				String name=rs.getString("name");
				obj.println("<br>Welcome "+name);
				obj.println("<br>Login Successful");
				obj.println("<br>Click <a href=\"/SimpleLoginProject/login.jsp\">here</a> to login");
				
			}
			else {
				obj.println("Login Failure");
				obj.println("<br>Click <a href=\"/SimpleLoginProject/login.jsp\">here</a> to login");
				obj.println("Login Unsuccessful");
			}
		} catch (Exception e) {
			// TODO: handle exception
			obj.println(e);
		}
//		obj.println("welcome");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

package userlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Connection con=null;
    public void init(ServletConfig config)
    {
    	String driver=config.getInitParameter("driver");
    	String url=config.getInitParameter("url");
    	String username=config.getInitParameter("username");
    	String password=config.getInitParameter("password");
    	try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println(e);
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter obj=response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			PreparedStatement st=con.prepareStatement("insert into users values ('"+name+"','"+username+"','"+password+"')");
			st.executeUpdate();
			obj.println("Registered Successfully<br>");
			obj.println("Click <a href=\"/SimpleLoginProject/login.jsp\">here</a> to login");
		} catch (Exception e) {
			// TODO: handle exception
			obj.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void destroy()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import clases.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		urlPatterns = {"/LoginServlet"}
)


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Set<Usuario> usuarios= new HashSet<Usuario>();
	private String mensaje;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public LoginServlet() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		

		this.usuarios = (Set<Usuario>) getServletContext().getAttribute("Usuarios");	
		String nombre =request.getParameter("usuario");
		String password =request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");	
		for (Usuario p : this.usuarios) {
			out.println("<h1>"+ p.getNombre()+ "</h1>");
		}
		out.println("</body></html>");	
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}

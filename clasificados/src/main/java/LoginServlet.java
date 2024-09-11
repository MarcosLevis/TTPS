import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Optional;

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
		Usuario user = this.usuarios.stream()
				.filter(u -> u.getNombre().equals(nombre) && u.getPassword().equals(password))
				.findFirst().orElse(null);
		
		if (user != null) {					
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Menu");		
			request.setAttribute("perfil", user.getPerfil());
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("error.html");
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}

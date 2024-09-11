import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(
		urlPatterns = {"/Premio"},
		initParams = { 
		@WebInitParam(name = "mensaje", value = "Hola como estas nombre")
})

public class Premio extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String mensaje;
	    /**
     * Default constructor. 
     */
    public Premio() {
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) {
    	mensaje = config.getInitParameter("mensaje");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		String nombreNuevo =request.getParameter("nombre");
		out.println("<h1>"+ this.mensaje.replace("nombre", nombreNuevo)+ " </h1>");
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
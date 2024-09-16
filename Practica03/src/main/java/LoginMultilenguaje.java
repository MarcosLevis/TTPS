

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginMultilenguaje
 */

@WebServlet(
		urlPatterns = {"/LoginMultilenguaje"}
)
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMultilenguaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lang = (String) request.getAttribute("lang");
		MultiLanguageSupport langSupport = new MultiLanguageSupport(lang);
		String titulo = langSupport.getText("titulo");
        String labelUsuario = langSupport.getText("labelusuario");
        String labelPassword = langSupport.getText("labelpassword");
        
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String s = "vuelve";
		out.println("<html><body>");
		out.println("<h1>" + titulo + "<h1>");
		out.println("<form action=Practica03Servlet method=\"post\" > ");
		out.println( "<label for=\"usuario\">"+ labelUsuario + "</label>");
		out.println(  "<input type=\"text\" id=\"usuario\" name=\"usuario\" />");
		out.println("<label for=\"password\">"+ labelPassword + "</label>");
		out.println("<input type=\"text\" id=\"password\" name=\"password\" />");
		out.println("<input type=\"submit\" value=\"enviar\" /></body>");
	
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



import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Estadistica
 */
@WebServlet(
		urlPatterns = {"/Estadistica"}
)
public class Estadistica extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Estadistica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**\
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int abonos2diasVendidos =  Integer.parseInt((String) getServletContext().getAttribute("Abonos2Dias"));
		int abonos3diasVendidos = 	Integer.parseInt((String) getServletContext().getAttribute("Abonos3Dias"));
		int abonos2diasIniciales =  Integer.parseInt(getServletContext().getInitParameter("Abonos2Dias"));
		int abonos3diasIniciales = 	Integer.parseInt(getServletContext().getInitParameter("Abonos3Dias"));
		PrintWriter out = response.getWriter();
		out.println("<head>\n"
				+ "	<meta charset=\"UTF-8\">\n"
				+ "	<title>LevisMarcos</title>\n"
				+ "	<link rel=\"stylesheet\" href=\"style.css\">\n"
				+ "</head>");
		out.println("<body>");
		out.println("<a href=\"index.html\">" + "inicio" + "</a>");
		out.println("<h2>"+ "Abono por 2 dias - Se vendieron: " + "<h2>");
		out.println("<h2>"+ (abonos2diasIniciales - abonos2diasVendidos ) + "</h2>");

		out.println("<h2>"+ "Abono por 3 dias - Se vendieron: " + "<h2>");
		out.println("<h2>"+ (abonos3diasIniciales - abonos3diasVendidos ) + "</h2>");

		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

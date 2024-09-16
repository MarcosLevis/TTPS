import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

public class FiltroEntradasAgotadas extends HttpFilter implements Filter {

    public FiltroEntradasAgotadas() {
        super();
    }

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		int abonos2dias =  Integer.parseInt((String) getServletContext().getAttribute("Abonos2Dias"));
		int abonos3dias = 	Integer.parseInt((String) getServletContext().getAttribute("Abonos3Dias"));
		String dias = request.getParameter("dias");
		if ((abonos2dias <= 0) && (abonos3dias <= 0)) {
			((HttpServletResponse) response).sendRedirect("EntradasAgotadas.html");
		} else if ((dias.equals("2") && (abonos2dias <= 0))) {
			((HttpServletResponse) response).sendRedirect("AbonosAgotados.html");
		}else if ((dias.equals("3") && (abonos3dias <= 0)) ) {
			((HttpServletResponse) response).sendRedirect("AbonosAgotados.html");
		}
		chain.doFilter(request, response);
	}

}

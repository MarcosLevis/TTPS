

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Servlet Filter implementation class FiltroLogDeAccesos
 */
public class FiltroLogDeAccesos extends HttpFilter implements Filter {
      private FilterConfig config;
      
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroLogDeAccesos() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(FilterConfig config) throws ServletException{
    	this.config = config;
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("IP: " + ((HttpServletRequest) req).getRemoteAddr());
		System.out.println("Fecha: " + LocalDateTime.now());
		System.out.println("RequestLine: " +((HttpServletRequest) req).getMethod() + " " + ((HttpServletRequest) req).getRequestURI() +" "+((HttpServletRequest) req).getProtocol());
		System.out.println("User-Agent: " + ((HttpServletRequest) req).getHeader("User-Agent"));
		chain.doFilter(req, resp);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */


}

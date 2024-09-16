
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
/**
 * Application Lifecycle Listener implementation class ListenerAbono
 *
 */
@WebListener
public class ListenerAbono implements ServletContextListener, ServletContextAttributeListener {

    /**
     * Default constructor.
     */
    public ListenerAbono() {
        // TODO Auto-generated constructor stub
    }


	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
	public void contextInitialized(ServletContextEvent sce)  {

    	// me traigo los parametros de inicializacion del xml
		String abono2dias = sce.getServletContext().getInitParameter("Abonos2Dias");
		String abono3dias = sce.getServletContext().getInitParameter("Abonos3Dias");

		//Se crea el contexto del servlet
		ServletContext contexto = sce.getServletContext();

		//agrego los bonos
		contexto.setAttribute("Abonos2Dias", abono2dias);
		contexto.setAttribute("Abonos3Dias", abono3dias);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
	public void contextDestroyed(ServletContextEvent sce)  {
         // TODO Auto-generated method stub
    }


}

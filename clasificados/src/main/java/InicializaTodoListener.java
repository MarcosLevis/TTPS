import jakarta.servlet.ServletContext;

import java.util.HashSet;
import java.util.Set;

import clases.Usuario;
import clases.SitioClasificado;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class InicializaTodoListener implements ServletContextListener{


	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	public void contextInitialized(ServletContextEvent sce) {
		
		// creo la lista de usuarios
		Usuario user1 = new Usuario("Marcos", "Levis", "Administrador");
		Usuario user2 = new Usuario("Mora", "Galarza", "Publicador");
		Set<Usuario> usuarios= new HashSet<Usuario>();
		usuarios.add(user1);
		usuarios.add(user2);
		
		// me traigo los parametros de inicializacion del xml
		String nombre = sce.getServletContext().getInitParameter("nombre");
		String telefono = sce.getServletContext().getInitParameter("telefono");
		String mail = sce.getServletContext().getInitParameter("mail");
		SitioClasificado sitio = new SitioClasificado(nombre,telefono,mail);
		
		//Se crea el contexto del servlet
		ServletContext contexto = sce.getServletContext();
		
		//agrego los usuarios
		contexto.setAttribute("Usuarios", usuarios);	
		contexto.setAttribute("SitioClasificado", sitio);
		
	}
	
}
		

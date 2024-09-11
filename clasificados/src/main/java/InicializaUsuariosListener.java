import jakarta.servlet.ServletContext;

import java.util.HashSet;
import java.util.Set;

import clases.Usuario;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class InicializaUsuariosListener implements ServletContextListener{


	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	public void contextInitialized(ServletContextEvent sce) {
		Usuario user1 = new Usuario("Marcos", "Levis");
		Usuario user2 = new Usuario("Mora", "Galarza");
		Set<Usuario> usuarios= new HashSet<Usuario>();
		usuarios.add(user1);
		usuarios.add(user2);
		
		//String peli1 = sce.getServletContext().getInitParameter("Usuarios"); 
				//esto es para traerme el paramvalue seteando en el webxml
		
		//Se crea el contexto del servlet
		ServletContext contexto = sce.getServletContext();
		contexto.setAttribute("Usuarios", usuarios);		
		
	}
	
}
		

package sicoi.model.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sicoi.model.entities.Usuario;;
/**
 * Session Bean implementation class ManagerUsuarios
 */
@Stateless
@LocalBean
public class ManagerUsuarios {
	@PersistenceContext(unitName = "sicoiDS")
	private EntityManager em;
    public ManagerUsuarios() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean comprobarUsuario(String idUsuario, String passwordUsuario) throws Exception {
    	Usuario us=em.find(Usuario.class, idUsuario);
    	//Usuario u=em.find(arg0, arg1)
    	//System.out.println("user "+emailUsuario);
    	if(us==null)
    		throw new Exception("No Existe el Usuario "+idUsuario);
    	if(!us.getEstadoUsuario())
    		throw new Exception("El usuario NO está activo");
    	if(us.getPasswordUsuario().equals(passwordUsuario))
    		return true;
    	throw new Exception("Contraeña Incorrecta!!");
    }
}

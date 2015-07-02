package org.sysHotel.dao;



import org.hibernate.Query;
import org.hibernate.Session;
import org.sysHotel.dao.generic.GenericHibernateDao;
import org.sysHotel.entity.LoginUser;
import org.sysHotel.entity.Roles;
import org.sysHotel.entity.Usuario;
import org.sysHotel.enums.EnumAtivoInativo;

/**
 * @author MarioJr
 *
 */
public class UsuarioDao extends GenericHibernateDao<Usuario, Long>{

	
	public LoginUser  buscaUserByLogin(String login){
		Session s = (Session)getEntityManager().getDelegate();
		Query q = s.createQuery(" from loginuser where login =:argLogin");
		q.setParameter("argLogin", login);
		LoginUser result = (LoginUser) q.uniqueResult();
		if(result!= null){
			return result;
		}else{
			return null;
		}
	}
	
	public void salvar(Usuario entity) {
		entity.setAtivoInativo(EnumAtivoInativo.ATIVO);
		super.save(entity);
	}
	
}

package org.sysHotel.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.sysHotel.dao.generic.GenericHibernateDao;
import org.sysHotel.entity.Usuario;
import org.sysHotel.enums.EnumAtivoInativo;

/**
 * @author MarioJr
 *
 */
public class UsuarioDao extends GenericHibernateDao<Usuario, Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4927908437063394251L;

	public Usuario usuarioByLogin(String login){
		Session s = (Session)getEntityManager().getDelegate();
		Criteria criteria = s.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("ativoInativo", EnumAtivoInativo.ATIVO));
		@SuppressWarnings("unchecked")
		List<Usuario> result = criteria.list();
		if(result.isEmpty()){
			return null;
		}else{
			return result.get(0);
		}
	}
	
	public void salvar(Usuario entity) {
		entity.setAtivoInativo(EnumAtivoInativo.ATIVO);
		super.save(entity);
	}
	
}

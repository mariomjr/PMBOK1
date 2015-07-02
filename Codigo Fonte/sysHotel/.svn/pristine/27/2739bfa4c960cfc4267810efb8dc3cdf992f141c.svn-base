package org.sysHotel.dao;

import org.sysHotel.dao.generic.GenericHibernateDao;
import org.sysHotel.entity.Roles;
import org.sysHotel.enums.EnumAtivoInativo;

/**
 * @author MarioJr
 *
 */
public class RolesDaoImpl extends GenericHibernateDao<Roles, Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 251332828389877452L;

	public void salvar(Roles entity) {
		entity.setAtivoInativo(EnumAtivoInativo.ATIVO);
		super.save(entity);
	}

}

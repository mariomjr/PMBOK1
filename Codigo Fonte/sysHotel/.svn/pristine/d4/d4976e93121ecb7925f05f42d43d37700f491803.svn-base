package org.sysHotel.converter;

import javax.annotation.Resource;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.sysHotel.dao.PerfilAcessoDaoImpl;
import org.sysHotel.entity.PerfilAcesso;
import org.sysHotel.interfaces.IPerfilAcessoDao;

@RequestScoped
@FacesConverter(value="perfilAcessoConverter",forClass=PerfilAcesso.class)
public class PerfilAcessoConverter implements Converter {
	
	@Resource
	IPerfilAcessoDao iPerfilAcessoDao;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		 if(arg2 == null || arg2.isEmpty()){
	            return null;
        }else{
            Long id = Long.parseLong(arg2);
            iPerfilAcessoDao = new PerfilAcessoDaoImpl();
            PerfilAcesso unidade = iPerfilAcessoDao.getById(id);
            return unidade;
        }
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		String str = "";
		if (arg2 instanceof PerfilAcesso) {
			str = ((PerfilAcesso) arg2).getId().toString(); 
		}
		return str; 

	}

}

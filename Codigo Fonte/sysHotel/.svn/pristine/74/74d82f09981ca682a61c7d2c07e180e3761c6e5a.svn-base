package org.sysHotel.converter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Double.class, value="doubleConverter")
public class doubleConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valorTela) {
		if(valorTela == null || valorTela.toString().trim().equals("")){  
			return 0.0d;  
	
		} else {  
			valorTela = valorTela.replaceAll(Pattern.quote("."), "");  
	
			try{  
	
				NumberFormat nf = NumberFormat.getInstance();  
	
				 Double a =nf.parse(valorTela.replace(".", ",")).doubleValue(); 
				return  a;
	
			}catch (Exception e) {  
				return 0.0d;  
			}  
		}  
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valorTela) {
		if(valorTela == null || valorTela.toString().trim().equals("")){  
			return null;  
	
		} else {  
			//NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
			NumberFormat nf = NumberFormat.getIntegerInstance(new Locale("pt", "BR"));
			nf.setMinimumFractionDigits(2);
			nf.setMaximumFractionDigits(2);
			String s= nf.format(Double.valueOf(valorTela.toString()));
			return  s; 
		}
	}
	
}

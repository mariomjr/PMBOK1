package org.sysHotel.interfaces;

import java.io.Serializable;

public interface ILoginBean extends Serializable {
	public String autenticar();
	
	public String logout();
}

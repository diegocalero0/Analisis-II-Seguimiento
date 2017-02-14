package entidades;

import java.io.Serializable;
import java.lang.Double;

/**
 * ID class for entity: PuntoLugar
 *
 */ 
public class PuntoLugarPK  implements Serializable {   
   
	         
	private Double longitud;         
	private Double latitud;
	private static final long serialVersionUID = 1L;

	public PuntoLugarPK() {}

	

	public Double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	

	public Double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof PuntoLugarPK)) {
			return false;
		}
		PuntoLugarPK other = (PuntoLugarPK) o;
		return true
			&& (getLongitud() == null ? other.getLongitud() == null : getLongitud().equals(other.getLongitud()))
			&& (getLatitud() == null ? other.getLatitud() == null : getLatitud().equals(other.getLatitud()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getLongitud() == null ? 0 : getLongitud().hashCode());
		result = prime * result + (getLatitud() == null ? 0 : getLatitud().hashCode());
		return result;
	}
   
   
}

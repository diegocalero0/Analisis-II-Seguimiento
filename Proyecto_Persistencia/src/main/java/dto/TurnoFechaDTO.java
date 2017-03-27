package dto;

import java.io.Serializable;

public class TurnoFechaDTO implements Serializable{
	
	/**
	 * numero de serialización
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * numero del turno
	 */
	private int turnoNumero;
	/**
	 * nombre del servicio del turno
	 */
	private String nombreServicioTurno;
	/**
	 * cedula del cliente atendido con el turno en cuestion
	 */
	private String cedulaClienteTurno;
	/**
	 * nombre del cliente atendido con el turno en cuestion
	 */
	private String nombreClienteTurno;
	/**
	 * correo del cliente atendido con el turno en cuestion
	 */
	private String correoClienteTurno;
	
	/**
	 * Constructor del DTO TurnoFecha
	 * @param turnoNumero
	 * @param nombreServicioTurno
	 * @param cedulaClienteTurno
	 * @param nombreClienteTurno
	 * @param correoClienteTurno
	 */
	public TurnoFechaDTO(int turnoNumero, String nombreServicioTurno, String cedulaClienteTurno,
			String nombreClienteTurno, String correoClienteTurno) {
		this.turnoNumero = turnoNumero;
		this.nombreServicioTurno = nombreServicioTurno;
		this.cedulaClienteTurno = cedulaClienteTurno;
		this.nombreClienteTurno = nombreClienteTurno;
		this.correoClienteTurno = correoClienteTurno;
	}

	/**
	 * @return the turnoNumero
	 */
	public int getTurnoNumero() {
		return turnoNumero;
	}

	/**
	 * @param turnoNumero the turnoNumero to set
	 */
	public void setTurnoNumero(int turnoNumero) {
		this.turnoNumero = turnoNumero;
	}

	/**
	 * @return the nombreServicioTurno
	 */
	public String getNombreServicioTurno() {
		return nombreServicioTurno;
	}

	/**
	 * @param nombreServicioTurno the nombreServicioTurno to set
	 */
	public void setNombreServicioTurno(String nombreServicioTurno) {
		this.nombreServicioTurno = nombreServicioTurno;
	}

	/**
	 * @return the cedulaClienteTurno
	 */
	public String getCedulaClienteTurno() {
		return cedulaClienteTurno;
	}

	/**
	 * @param cedulaClienteTurno the cedulaClienteTurno to set
	 */
	public void setCedulaClienteTurno(String cedulaClienteTurno) {
		this.cedulaClienteTurno = cedulaClienteTurno;
	}

	/**
	 * @return the nombreClienteTurno
	 */
	public String getNombreClienteTurno() {
		return nombreClienteTurno;
	}

	/**
	 * @param nombreClienteTurno the nombreClienteTurno to set
	 */
	public void setNombreClienteTurno(String nombreClienteTurno) {
		this.nombreClienteTurno = nombreClienteTurno;
	}

	/**
	 * @return the correoClienteTurno
	 */
	public String getCorreoClienteTurno() {
		return correoClienteTurno;
	}

	/**
	 * @param correoClienteTurno the correoClienteTurno to set
	 */
	public void setCorreoClienteTurno(String correoClienteTurno) {
		this.correoClienteTurno = correoClienteTurno;
	}
	
	
	
}

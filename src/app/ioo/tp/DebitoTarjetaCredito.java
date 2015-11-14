package app.ioo.tp;

import java.util.Date;

public class DebitoTarjetaCredito extends MedioDePago {

	private String entidad_emisora;
	
	private long numero_tarjeta;
	
	private Date fecha_vencimiento;
	
	public DebitoTarjetaCredito(String entidad_emisora, long numero_tajeta, Date fecha_vencimiento) {
		super();
		
		this.entidad_emisora = entidad_emisora;
		this.numero_tarjeta = numero_tajeta;
		this.fecha_vencimiento = fecha_vencimiento;		
	}

	// GET Y SET DE LOS ATRIBUTOS
	
	public String getEntidad_emisora() {
		return entidad_emisora;
	}

	public void setEntidad_emisora(String entidad_emisora) {
		this.entidad_emisora = entidad_emisora;
	}

	public long getNumero_tarjeta() {
		return numero_tarjeta;
	}

	public void setNumero_tarjeta(long numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}
}
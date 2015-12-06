package app.ioo.tp;

import java.util.Date;

/**
 * 
 */
public class Contrato {

	public static final int ESTADO_ACTIVO = 0; // ES CUANDO SE CREA UN NUEVO CONTRATO Y SE ESTA USANDO
	public static final int ESTADO_INACTIVO = 1; // ES CUANDO SE TIENE UN CONTRATO Y SE DA DE BAJA EN EL SISTEMA
//	public static final int ESTADO_TERMINADO = 2; // ES CUANDO EL CONTRATO TERMINA EL PERIODO DE FIN
	
	private static long ultimoContrato;
	
	private long numero_contrato;
	
	private Date periodo_inicio;
	
	private Date periodo_fin;
	
	private int estado;
	
	private Cliente cliente;
	
	private Cochera cochera;
	
	private MedioDePago medio_de_pago;
	
	private CuentaCorriente cuenta_corriente;
	

	public Contrato(Date periodo_inicio, Date periodo_fin, Cliente cliente, Cochera cochera, MedioDePago medio_de_pago) {
		
		this.numero_contrato = ++ultimoContrato; 
		this.periodo_inicio = periodo_inicio;
		this.periodo_fin = periodo_fin;
		this.cliente = cliente;
		this.cochera = cochera;
		this.medio_de_pago = medio_de_pago;
		this.estado = ESTADO_ACTIVO;
		this.cuenta_corriente = new CuentaCorriente(0);
	}

	/**
	 * Verifica que el cliente, la cochera y el periodo por parametro coincidan con el objeto
	 * 
	 * @param cliente 
	 * @param cochera
	 * @param periodoInicio 
	 * @param periodoFin 
	 * @return boolean
	 */
	public boolean tienesContrato(Cliente cliente, MedioDePago medioDePago, Cochera cochera, Date periodoInicio, Date periodoFin) {
		
		return (	
					this.cliente.equals(cliente) 
				&& 	this.medio_de_pago.equals(medioDePago)
				&& 	this.cochera.equals(cochera) 
				&& 	getPeriodo_inicio().equals(periodoInicio) 
				&&	getPeriodo_fin().equals(periodoFin)
				&&	getEstado() == ESTADO_ACTIVO
			);
	}
	
	/**
	 * GENERO UN MOVIMIENTO A LA CUENTA CORRIENTE DEL CONTRATO COMO COBRO
	 * DEL MONTO DE LA COCHERA EN QUE ESTA
	 * 
	 * @param Date fecha DEL MOVIMIENTO 
	 */
	public void generarCobranza(Date fecha) {
		double monto = getCochera().getCostoCochera();

		getCuenta_corriente().agregarMovimiento(fecha, MovimientoCC.MOVIMIENTO_COBRO, monto);
	}
	
	/**
	 * GENERO UN MOVIMIENTO A LA CUENTA CORRIENTE DEL CONTRATO COMO PAGO
	 * DEL MONTO DE LA COCHERA EN QUE ESTA
	 * 
	 * @param Date fecha DEL MOVIMIENTO
	 * @param double pago EL MONTO QUE PAGO
	 */
	public void generarPago(Date fecha, double pago) {
		getCuenta_corriente().agregarMovimiento(fecha, MovimientoCC.MOVIMIENTO_PAGO, pago);
	}
	
	// GET Y SET DE LOS ATRIBUTOS

	public long getNumero_contrato() {
		return numero_contrato;
	}

	public void setNumero_contrato(long numero_contrato) {
		this.numero_contrato = numero_contrato;
	}

	public Date getPeriodo_inicio() {
		return periodo_inicio;
	}

	public void setPeriodo_inicio(Date periodo_inicio) {
		this.periodo_inicio = periodo_inicio;
	}

	public Date getPeriodo_fin() {
		return periodo_fin;
	}

	public void setPeriodo_fin(Date periodo_fin) {
		this.periodo_fin = periodo_fin;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cochera getCochera() {
		return cochera;
	}

	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}

	public MedioDePago getMedio_de_pago() {
		return medio_de_pago;
	}

	public void setMedio_de_pago(MedioDePago medio_de_pago) {
		this.medio_de_pago = medio_de_pago;
	}

	public CuentaCorriente getCuenta_corriente() {
		return cuenta_corriente;
	}

	public void setCuenta_corriente(CuentaCorriente cuenta_corriente) {
		this.cuenta_corriente = cuenta_corriente;
	}	
}
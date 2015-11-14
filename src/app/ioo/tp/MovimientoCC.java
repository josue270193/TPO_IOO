package app.ioo.tp;

import java.util.Date;

public class MovimientoCC {
	
	public static final int MOVIMIENTO_COBRO = 1;
	public static final int MOVIMIENTO_PAGO = 2;
	
	private static int ultimoID;
	
	private int id;
	
	private Date fecha;
	
	private int tipo; 	// 1 - MOVIMIENTO DE COBRO
						// 2 - MOVIMIENTO DE PAGO
	
	private double monto;

	public MovimientoCC(Date fecha, int tipo, double monto) {

		this.id = ++ultimoID;
		
		this.fecha = fecha;
		this.tipo = tipo;
		this.monto = monto;
	}

	// GET Y SET DE LOS ATRIBUTOS
	
	public Date getFecha() {
		return fecha;
	}

	/*public void setFecha(Date fecha) {
		this.fecha = fecha;
	}*/

	public int getTipo() {
		return tipo;
	}

	/*public void setTipo(int tipo) {
		this.tipo = tipo;
	}*/

	public double getMonto() {
		return monto;
	}

	/*public void setMonto(double monto) {
		this.monto = monto;
	}*/
	
	
}

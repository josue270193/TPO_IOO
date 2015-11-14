package app.ioo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CuentaCorriente {

	private static int ultimoID;
	
	private int numero_cuenta;
	
	private double saldo;
	
	private List<MovimientoCC> movimientos;
	
	public CuentaCorriente(double saldo) {
				
		this.numero_cuenta = ++ultimoID;
		this.saldo = 0;
		this.movimientos = new ArrayList<MovimientoCC>();
	}

	// GET Y SET DE LOS ATRIBUTOS

	public int getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(int numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public double getSaldo() {		
		return saldo;
	}

	/*public void setSaldo(double saldo) {
		this.saldo = saldo;
	}*/

	/*public List<MovimientoCC> getMovimientos() {
		return movimientos;
	}*/

	/*public void setMovimientos(List<MovimientoCC> movimientos) {
		this.movimientos = movimientos;
	}*/
	
	public void agregarMovimiento(Date fecha, int tipo, double monto ){
		MovimientoCC mov = new MovimientoCC(fecha, tipo, monto);
		
		movimientos.add(mov);
		
		if(mov.getTipo()==mov.MOVIMIENTO_COBRO)
			saldo =- mov.getMonto();		
		else if(mov.getTipo()==mov.MOVIMIENTO_PAGO)
			saldo =+ mov.getMonto();
	}
}

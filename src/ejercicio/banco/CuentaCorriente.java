package ejercicio.banco;
public class CuentaCorriente extends Cuenta {
	
	private int descubierto;
	
	public CuentaCorriente (Cliente cl)
	{
		super (cl);
		descubierto = 1000;
	}

	public void extraer(int monto)
	{
		if (saldo + descubierto >= monto)
		{
			saldo = saldo - monto;
		}
	}
}

package ejercicio.banco;


public class CajaAhorro extends Cuenta {
	
	
	public CajaAhorro(Cliente cl )
	{
		super (cl);
	}

	public void extraer(int monto)
	{
		if (saldo >= monto)
		{
			saldo = saldo - monto;
		}
	}
}

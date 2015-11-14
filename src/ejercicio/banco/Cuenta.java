package ejercicio.banco;
public abstract class Cuenta {
	
	protected int numero;
	protected int saldo;
	protected Cliente cliente;
	private static int ultNro;
	
	public Cuenta (Cliente cl)
	{
		numero = Cuenta.getUltNro();
		cliente = cl;
		saldo = 0;
	}
	
	public static int getUltNro()
	{
		return ++ultNro ;
	}
	
	public boolean sosLaCuenta(int nro)
	{
		if (numero == nro)
		{
			return true;
		}
		return false;
	}
	
	public void debitar (int monto)
	{
		saldo = saldo + monto;
	}
	
	public VistaCuenta crearVista()
	{
		VistaCuenta vc;
		return vc = new VistaCuenta(numero, cliente.getNombre(), saldo);
	}
	
	
	public abstract void extraer(int monto);
}

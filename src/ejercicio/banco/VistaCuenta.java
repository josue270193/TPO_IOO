package ejercicio.banco;

public class VistaCuenta {
	
	private int numero;
	private String nombre;
	private int saldo;
	
	public VistaCuenta (int numero, String nombre, int saldo)
	{
		this.numero = numero;
		this.nombre = nombre;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public int getSaldo() {
		return saldo;
	}
	
	

}

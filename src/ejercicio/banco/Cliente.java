package ejercicio.banco;

public class Cliente {

	private String dni;
	private String nombre;
	
	public Cliente (String dni, String nombre)
	{
		this.dni = dni;
		this.nombre = nombre;
	}

	public boolean sosElCliente(String dni)
	{
		if (this.dni.equals(dni))
		{
			return true;
		}
		return false;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}

package app.ioo.tp;

/**
 *	
 * Clase que define el auto
 * 
 * @author 
 * 
 */
public class Auto {

	private String patente;

	private String marca;

	private String modelo;

	private long tamanno;

	public Auto(String patente, String marca, String modelo, long tamanno) {
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.tamanno = tamanno;
	}

	// GET Y SET DE LOS ATRIBUTOS
	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public long getTamanno() {
		return tamanno;
	}

	public void setTamanno(long tamanno) {
		this.tamanno = tamanno;
	}
	
	
}
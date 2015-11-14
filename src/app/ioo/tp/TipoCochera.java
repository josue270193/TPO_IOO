package app.ioo.tp;

/**
 * Clase en la cual se especifica los tipo de cochera
 * 
 * @author Josue David Lopez LU: 1059865
 *
 */
public class TipoCochera {

	// TAMAÑOS ARBITRARIO
	public static final long TAMANO_PEQUENA = 10l; 
	public static final long TAMANO_MEDIANA = 20l;
	public static final long TAMANO_GRANDE = 30l;

	private long tamano;
	
	public TipoCochera(long tamano) {
		this.tamano = tamano;
	}

	// GET Y SET DE LOS ATRIBUTOS
	
	public long getTamano() {
		return tamano;
	}

	public void setTamano(long tamano) {
		this.tamano = tamano;
	}	
	
}

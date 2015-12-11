package app.ioo.tp;

import app.ioo.tp.vistas.MedioDePagoView;

/**
 * Clase padre donde se origina los medios de pagos
 * 
 * @author Josue David Lopez LU: 1059865
 *
 */
public abstract class MedioDePago {

	public static final int EFECTIVO = 0; 
	public static final int DEBITO_CBU = 1; 
	public static final int DEBITO_TARJETA_CREDITO = 2;

	private static int ultimoID;

	protected int id;
	protected boolean activo;

	public MedioDePago() {
		this(++ultimoID);
	}

	
	public MedioDePago(int id) {		
		this.id = id;
		this.activo = true;
	}

	// GET Y SET DE LOS ATRIBUTOS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public boolean equals(Object o) {	
		if (o instanceof MedioDePago){
			return getId() == ((MedioDePago) o).getId(); 
		}
		return false;
	}

	public abstract MedioDePagoView crearMedioDePagoView();
}
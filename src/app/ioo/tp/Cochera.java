package app.ioo.tp;

/**
 * 
 * Clase de la cochera a la cual tiene asociado un {@link TipoCochera}
 * 
 * @author 
 * 
 */
public class Cochera {
	
	public static final int ESTADO_DISPONIBLE = 0;
	public static final int ESTADO_OCUPADO = 1;
	public static final int ESTADO_BLOQUEADO = 2;
	
	private static int ultimoID;
	
	private int numero;
	
	private TipoCochera tipo;
	
	private double costoCochera;
	
	private int disponible;

	private Auto auto;
	
	public Cochera(TipoCochera tipo, double costoCochera) {
		this(++ultimoID, tipo, costoCochera, ESTADO_DISPONIBLE);
	}
	
	public Cochera(TipoCochera tipo, double costoCochera, int disponible) {
		this(++ultimoID, tipo, costoCochera, disponible);
	}
	
	public Cochera(int numero, TipoCochera tipo, double costoCochera, int disponible) {
		this.numero = numero;
		this.tipo = tipo;
		this.costoCochera = costoCochera;
		this.disponible = disponible;
		this.auto = null;
	}

	/**
	 * Verifica que el tama�o del auto entre en la cochera y que la misma este disponible
	 * 
	 * @param long tama�o del auto que se quiere ingresar
	 * @return boolean
	 */
	public boolean esDisponible(long tamannoAuto) {		
		return (tamannoAuto <= getTipo().getTamano() && getDisponible() == 0);
	}
	
	/**
	 * OCUPO LA COCHERA CON UN AUTO QUE SE CREA A PARTIR DE LOS PARAMETROS DE PASADOS POR PARAMETROS	 * 
	 * 
	 * @param patente
	 * @param marca
	 * @param modelo
	 * @param tamanno
	 */
	public void ocuparCochera(String patente, String marca, String modelo, long tamanno){
		Auto autoEntrante = new Auto(patente, marca, modelo, tamanno);
		
		auto = autoEntrante;
		setDisponible(ESTADO_OCUPADO);
	}
	
	public void desocuparCochera(){
		auto=null;
		setDisponible(ESTADO_DISPONIBLE);
	}
	
	public void bloquearCochera(){
		setDisponible(ESTADO_BLOQUEADO);
	}
	
	
	
	// GET Y SET DE LOS ATRIBUTOS
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public TipoCochera getTipo() {
		return tipo;
	}

	public void setTipo(TipoCochera tipo) {
		this.tipo = tipo;
	}

	public double getCostoCochera() {
		return costoCochera;
	}

	public void setCostoCochera(double costoCochera) {
		this.costoCochera = costoCochera;
	}
	
	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Cochera){
			return ((Cochera) o).getNumero() == getNumero(); 
		}
		return false;
	}
}
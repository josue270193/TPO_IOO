package app.ioo.tp;

public class DebitoCBU extends MedioDePago {

	private String entidad_bancaria;
	
	private String cbu;
	
	public DebitoCBU(String entidad_bancaria, String cbu) {		
		super();
		
		this.entidad_bancaria = entidad_bancaria;
		this.cbu = cbu;
	}

	// GET Y SET DE LOS ATRIBUTOS
	
	public String getEntidad_bancaria() {
		return entidad_bancaria;
	}

	public void setEntidad_bancaria(String entidad_bancaria) {
		this.entidad_bancaria = entidad_bancaria;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}
	
}
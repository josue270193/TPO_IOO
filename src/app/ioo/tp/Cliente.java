package app.ioo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.ioo.tp.vistas.ClienteView;

/**
 *
 * Clase que tiene el Cliente 
 *
 * @author 
 */
public class Cliente {

	private String dni;
	
	private String nombre;
	
	private String domicilio;
	
	private String telefono;
	
	private String mail;
	
	private boolean estado;
	
	private List<MedioDePago> mediosDePago; // LISTA DE MEDIOS PAGOS PARA CADA CLIENTE
	
	public Cliente(String dni, String nombre, String domicilio, String telefono, String mail) {
		this(dni, nombre, domicilio, telefono, mail, true);
	}
	
	public Cliente(String dni, String nombre, String domicilio, String telefono, String mail, boolean estado) {
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.estado = estado;

		this.mediosDePago = new ArrayList<MedioDePago>();
	}

	/**
	 * Verifico que el cliente tiene el dni pasado por parametro
	 * 
	 * @param dni
	 * @return boolean TRUE si tengo el dni
	 * 
	 */
	public boolean tengoDNI(String dni) {
		return (getDni()==dni);
	}
	
	public boolean AgregarMedioDePagoEfectivo() {
		for(MedioDePago mdp: mediosDePago)
			if(mdp instanceof Efectivo)
				return false;

		mediosDePago.add(new Efectivo());
		return true;
	}
	
	public boolean AgregarMedioDePagoDebitoCBU(String CBU, String EntidadBancaria) {
		if(CBU.trim().isEmpty() || EntidadBancaria.trim().isEmpty())
			return false;

		for(MedioDePago mdp: mediosDePago)
			if(mdp instanceof DebitoCBU)
				if 	(
						((DebitoCBU) mdp).getCbu().compareTo(CBU) == 0
					&& 	((DebitoCBU) mdp).getEntidad_bancaria().compareTo(EntidadBancaria) == 0
				)
					return false;

		mediosDePago.add(new DebitoCBU(EntidadBancaria, CBU));
		return true;
	}
	
	public boolean AgregarMedioDePagoDebitoCredito(String entidad_emisora, long numero_tarjeta, Date fecha_vencimiento) {
		if( entidad_emisora.trim().isEmpty() || numero_tarjeta < 0 || fecha_vencimiento == null )
			return false;

		for(MedioDePago mdp: mediosDePago)
			if(mdp instanceof DebitoTarjetaCredito)
				if(
						((DebitoTarjetaCredito)mdp).getEntidad_emisora().compareTo(entidad_emisora) == 0
					&& 	((DebitoTarjetaCredito)mdp).getFecha_vencimiento().compareTo(fecha_vencimiento) == 0
					&& 	((DebitoTarjetaCredito)mdp).getNumero_tarjeta() == numero_tarjeta
				)
					return false;

		mediosDePago.add(new DebitoTarjetaCredito(entidad_emisora, numero_tarjeta, fecha_vencimiento));
		return true;
	}

	/**
	 * DA UNA BAJA LOGICA PARA QUE NO PUEDA USARSE MAS ESE MEDIO DE PAGO
	 * @param IdMediodePago
     */
	public void EliminarMedioDePago(int IdMediodePago ) {
		for(MedioDePago med : mediosDePago)
			if(med.getId() == IdMediodePago){
				med.setActivo(false);
			}
	}

	// GET Y SET DE LOS ATRIBUTOS
	
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

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<MedioDePago> getMediosDePago() {
		List<MedioDePago> medios = new ArrayList<MedioDePago>();
		for (MedioDePago m : mediosDePago){
			if (m.isActivo()){
				medios.add(m);
			}
		}
		return medios;
	}

	public void setMediosDePago(List<MedioDePago> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}

	/**
	 * SOBREESCRIBO EL METODO EQUAL PARA COMPARAR CLIENTES
	 */
	@Override 
	public boolean equals(Object o) {
		if (o instanceof Cliente){
			return tengoDNI(((Cliente) o).getDni()); 
		}
		return false;
	}

	/**
	 * REVISO SI TENGO EL ID DE UN MEDIO DE PAGO
	 * @param medioPagoId
	 * @return NULL SI NO TENGO EL MEDIO DE PAGO O EL MEDIO DE PAGO QUE BUSCO 
	 */
	public MedioDePago tengoMedioDePago(long medioPagoId) {
		for (MedioDePago medioPago : mediosDePago){
			if (medioPago.getId() == medioPagoId){
				return medioPago;
			}					
		}
		return null;
	}
	
	public MedioDePago tengoMedioDePagoEfectivos(long medioPagoId) {
		for (MedioDePago medioPago : mediosDePago){
			if (medioPago.getId() == medioPagoId){
				return medioPago;
			}					
		}
		return null;
	}

	public ClienteView getClienteView() {
		ClienteView view = new ClienteView(dni, nombre, domicilio, telefono, mail, estado);
		return view;
	}
}
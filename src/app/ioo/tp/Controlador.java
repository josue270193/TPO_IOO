package app.ioo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import app.ioo.tp.vistas.*;

/**
 * Clase que sirve de controlador para todo las funciones del sistema
 *
 * @author Josue David Lopez Hernandez LU: 1059865
 */
public class Controlador {

    private List<Cliente> clientes;
    private List<Cochera> cocheras;
    private List<Contrato> contratos;

    public Controlador() {
        this.clientes = new ArrayList<Cliente>();
        this.cocheras = new ArrayList<Cochera>();
        this.contratos = new ArrayList<Contrato>();
    }

    /**
     * SE CREA EL MAPA CON LA CANTIDAD DE COCHERA PARA PEQUE�A, MEDIANA Y GRANDE CON SUS MONTO CORRESPONDIENTE
     *
     * @param peq
     * @param montopeq
     * @param med
     * @param montomed
     * @param gde
     * @param montogde
     */
    public void crearMapaCochera(int peq, long montopeq, int med, long montomed, int gde, long montogde) {
        Cochera c = null;
        for (int i = 0; i < peq; i++) {
            c = new Cochera(new TipoCochera(TipoCochera.TAMANO_PEQUENA), montopeq);
            cocheras.add(c);
        }
        for (int i = 0; i < med; i++) {
            c = new Cochera(new TipoCochera(TipoCochera.TAMANO_MEDIANA), montomed);
            cocheras.add(c);
        }
        for (int i = 0; i < gde; i++) {
            c = new Cochera(new TipoCochera(TipoCochera.TAMANO_GRANDE), montogde);
            cocheras.add(c);
        }
    }

    /**
     * CREO UN CONTRATO A PARTIR DE UN DNI DE UN CLIENTE, CON UN ID DE PAGO EXISTENTE
     * SE CREA AL AUTO EN EL MOMENTO DEL CONTRATO SI TENGO DISPONIBLE
     *
     * @param dni           UN CLIENTE EXISTENTE
     * @param medioPagoId   UN MEDIO DE PAGO EXISTENTE DE ESE CLIENTE
     * @param patente
     * @param marca
     * @param modelo
     * @param tamanno
     * @param periodoInicio
     * @param periodoFin
     */
    public boolean crearContrato(String dni, long medioPagoId
            , String patente, String marca, String modelo, long tamanno
            , Date periodoInicio, Date periodoFin) {

        Cliente auxCliente = buscarCliente(dni); // BUSCO EL CLIENTE SI EXISTE

        if (auxCliente != null) {
            MedioDePago auxMedioPago = auxCliente.tengoMedioDePago(medioPagoId); // REVISO SI EL CLIENTE TIENE EL ID DEL MEDIO DE PAGO
            if (auxMedioPago != null) {
                Cochera auxCochera = buscarCocheraTamano(tamanno); // COMPRUEBO SI TENGO UNA COCHERA DISPONIBLE CON EL TAMA�O A USAR
                if (auxCochera != null) {
                    Contrato contratoExistente = exiteContrato(auxCliente, auxMedioPago, auxCochera, periodoInicio, periodoFin);
                    if (contratoExistente == null) {
                        contratoExistente = new Contrato(periodoInicio, periodoFin, auxCliente, auxCochera, auxMedioPago);
                        contratos.add(contratoExistente);
                        auxCochera.ocuparCochera(patente, marca, modelo, tamanno); // OCUPO LA COCHERA QUE ANTES ESTABA VACIA

                        return true;
                    }

                }
            }
        }
        return false;
    }

    /**
     * DOY DE BAJA LOGICA AL CONTRATO DE UN CLIENTE
     *
     * @param dni
     * @param idContrato
     */
    public void darBajaContrato(String dni, long idContrato) {
        Cliente aux = buscarCliente(dni); // BUSCO EL CLIENTE SI EXISTE

        if (aux != null) {
            Contrato auxContrato = existeContrato(idContrato); // BUSCO EL CLIENTE SI EXISTE
            if (auxContrato != null) {
                auxContrato.setEstado(Contrato.ESTADO_INACTIVO);
            }
        }
    }

    private Contrato existeContrato(long idContrato) {
        for (Contrato c : contratos) {
            if (c.getNumero_contrato() == idContrato) {
                return c;
            }
        }
        return null;
    }

    /**
     * REVISO SI EXISTE UN CONTRATO CON LOS PARAMETROS
     *
     * @param aux
     * @param auxMedioPago
     * @param auxCochera
     * @param periodoFin
     * @param periodoInicio
     * @return NULL SI NO TIENE EL CONTRATO O  EL CONTRATO A BUSCAR
     */
    private Contrato exiteContrato(Cliente aux, MedioDePago auxMedioPago, Cochera auxCochera, Date periodoInicio, Date periodoFin) {
        for (Contrato contrato : contratos) {
            if (contrato.tienesContrato(aux, auxMedioPago, auxCochera, periodoInicio, periodoFin)) {
                return contrato;
            }
        }
        return null;
    }

    /**
     * SI TENGO UN COCHERA DISPONIBLE CON EL TAMA�O QUE DESEO INSERTAR
     *
     * @param tamanno TAMA�O
     * @return NULL SI NO TENGO COCHERA O UNA COCHERA SI TENGO UNA
     */
    private Cochera buscarCocheraTamano(long tamanno) {
        for (Cochera cochera : cocheras) {
            if (cochera.esDisponible(tamanno))
                return cochera;
        }
        return null;
    }

    public boolean existeCocheraDisponible(long tamanno) {
        return (buscarCocheraTamano(tamanno) != null);
    }

    /**
     * REALIZO UN {@link MovimientoCC} DE COBRO DE UN CLIENTE DE UN CONTRATO CON EL MONTO Y LA FECHA
     * CON RESPECTO AL MONTO DE UN COCHERA
     *
     * @param dni
     * @param idContrato
     * @param fecha
     */
    public void realizarCobranza(String dni, long idContrato, Date fecha) {
        Cliente aux = buscarCliente(dni); // BUSCO EL CLIENTE SI EXISTE

        if (aux != null) {
            Contrato auxContrato = existeContrato(idContrato); // BUSCO EL CONTRATO SI EXISTE
            if (auxContrato != null) {
                auxContrato.generarCobranza(fecha);
            }
        }
    }

    /**
     * REALIZO UN {@link MovimientoCC} DE PAGO DE UN CLIENTE DE UN CONTRATO CON EL MONTO Y LA FECHA
     *
     * @param dni
     * @param idContrato
     * @param pago
     * @param fecha
     */
    public void realizarPago(String dni, long idContrato, double pago, Date fecha) {
        Cliente aux = buscarCliente(dni); // BUSCO EL CLIENTE SI EXISTE

        if (aux != null) {
            Contrato auxContrato = existeContrato(idContrato); // BUSCO EL CONTRATO SI EXISTE
            if (auxContrato != null) {
                auxContrato.generarPago(fecha, pago);
            }
        }
    }

    /**
     * @param int
     * @param medio
     */
    public boolean altaMedioDePagoEfectivo(String dni) {
        Cliente auxCliente = buscarCliente(dni);
        if (auxCliente != null)
            return auxCliente.AgregarMedioDePagoEfectivo();

        return false;
    }

    public boolean altaMedioDePagoDebitoCBU(String dni, String cbu, String entidadbancaria) {
        Cliente auxCliente = buscarCliente(dni);
        if (auxCliente != null)
            return auxCliente.AgregarMedioDePagoDebitoCBU(cbu, entidadbancaria);

        return false;
    }

    public boolean altaMedioDePagoDebitoTarjetaCredito(String dni, String entidad_emisora, long numero_tarjeta, Date fecha_vencimiento) {
        Cliente auxCliente = buscarCliente(dni);
        if (auxCliente != null)
            return auxCliente.AgregarMedioDePagoDebitoCredito(entidad_emisora, numero_tarjeta, fecha_vencimiento);

        return false;
    }

    /**
     * @param int
     * @param int
     * @param int
     */
    public boolean modificarMedioDePagoTarjetaCredito(String dni, int id_medio_de_pago, String entidad_emisora, long numero_tarjeta,
                                                   Date fecha_vencimiento) {
        Cliente auxCliente = buscarCliente(dni);
        if (auxCliente != null) {
            MedioDePago auxMedioPago = auxCliente.tengoMedioDePago(id_medio_de_pago); // BUSCO SI EXISTE EL MEDIO DE PAGO
            if (auxMedioPago != null && auxMedioPago instanceof DebitoTarjetaCredito) {
                ((DebitoTarjetaCredito) auxMedioPago).setEntidad_emisora(entidad_emisora);
                ((DebitoTarjetaCredito) auxMedioPago).setNumero_tarjeta(numero_tarjeta);
                ((DebitoTarjetaCredito) auxMedioPago).setFecha_vencimiento(fecha_vencimiento);
                return true;
            }
        }
        return false;
    }


    /**
     * @param int
     * @param int
     */
    public boolean modificarMedioDePagoDebitoCBU(String dni, int id_medio_de_pago,
                                              String entidad_bancaria, String cbu) {
        Cliente auxCliente = buscarCliente(dni); // BUSCO SI EXISTE EL CLIENTE
        if (auxCliente != null) {
            MedioDePago auxMedioPago = auxCliente.tengoMedioDePago(id_medio_de_pago); // BUSCO SI EXISTE EL MEDIO DE PAGO
            if (auxMedioPago != null && auxMedioPago instanceof DebitoCBU) {
                ((DebitoCBU) auxMedioPago).setEntidad_bancaria(entidad_bancaria);
                ((DebitoCBU) auxMedioPago).setCbu(cbu);
                return true;
            }
        }
        return false;
    }

    /**
     * @param DNI
     * @param Nombre
     * @param Domicilio
     * @param Telefono
     * @param Mail
     * @param Estado
     */
    public void crearCliente(String dni, String nombre, String domicilio, String telefono, String mail) {
        if (buscarCliente(dni) == null) {
            Cliente nuevoCliente = new Cliente(dni, nombre, domicilio, telefono, mail);
            clientes.add(nuevoCliente);            
        }        
    }

    /**
     * @param DNI
     */
    public void eliminarCliente(String DNI) {
        Cliente aux = buscarCliente(DNI);
        if (aux != null) {
            clientes.remove(aux);
            // TODO ELIMINAR CONTRATO Y MEDIOS DE PAGOS
        }
    }

    /**
     * @param Domicilio
     * @param Telefono
     * @param Mail
     * @param Estado
     */
    private void modificarCliente(String dni, String nombre, String domicilio, String telefono, String mail) {
        Cliente aux = buscarCliente(dni);
        System.out.println(aux);
        if (aux != null) {
            aux.setNombre(nombre);
            aux.setDomicilio(domicilio);
            aux.setTelefono(telefono);
            aux.setMail(mail);
        }
    }
    
    public boolean existeCliente(String dni) {
        return (buscarCliente(dni) != null);
    }
    
    private Cliente buscarCliente(String dni) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente aux = (Cliente) clientes.get(i);
            if (aux.getDni().equalsIgnoreCase(dni))
                return aux;
        }
        return null;
    }

    // METODOS PARA LAS VISTAS
        
	public ClienteView getClienteView(String dni) {
		if (existeCliente(dni)){
			return buscarCliente(dni).getClienteView();			
		}
		
		return null;
	}

	public void modificarCliente(ClienteView clienteView) {
		modificarCliente(clienteView.getDni(), clienteView.getNombre(), clienteView.getDomicilio(), clienteView.getTelefono(), clienteView.getMail());
	}

    /**
     * OBTENGO LOS MEDIOS DE PAGOS CON UNA VIEW CORRRESPONDIENTE PASANDO EL DNI COMO PARAMETRO
     * @param dni
     * @return
     */
    public List<MedioDePagoView> obtenerMediosPagoCliente(String dni) {
        List<MedioDePagoView> lista = new ArrayList<MedioDePagoView>();

        Cliente cliente = buscarCliente(dni);

        for (MedioDePago m : cliente.getMediosDePago()){
            if (m instanceof Efectivo){
                lista.add( new EfectivoView(m.getId()) );
            }
            else if (m instanceof DebitoCBU){
                lista.add( new DebitoCBUView(m.getId(), ((DebitoCBU) m).getCbu(),((DebitoCBU) m).getEntidad_bancaria())) ;
            }
            else if (m instanceof DebitoTarjetaCredito){
                lista.add(new DebitoTarjetaCreditoView(m.getId(), ((DebitoTarjetaCredito) m).getNumero_tarjeta(), ((DebitoTarjetaCredito) m).getEntidad_emisora(), ((DebitoTarjetaCredito) m).getFecha_vencimiento()));
            }
        }

        return lista;
    }

    public boolean eliminarMedioDePago(String dni, int idMedioDePago) {
        Cliente cliente = buscarCliente(dni);

        cliente.EliminarMedioDePago(idMedioDePago);

        return true;
    }

    /**
     * SE OBTIENE LOS CONTRATOS VIGENTES POR CLIENTE
     * @param dni
     * @return
     */
    public List<ContratoView> obtenerContratoVigentesCliente(String dni) {
        List<ContratoView> lista = new ArrayList<ContratoView>();

        Cliente cliente = buscarCliente(dni);
        for (Contrato c : contratos){
            if (c.getCliente().equals(cliente)){
                lista.add(c.getContratoView());
            }
        }

        return lista;
    }
    // GET Y SET DE LOS ATRIBUTOS
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Vector<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cochera> getCocheras() {
        return cocheras;
    }

    public void setCocheras(List<Cochera> cocheras) {
        this.cocheras = cocheras;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

}

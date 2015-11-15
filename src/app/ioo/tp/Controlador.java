package app.ioo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

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
    public void crearContrato(String dni, long medioPagoId
            , String patente, String marca, String modelo, long tamanno
            , Date periodoInicio, Date periodoFin) {

        Cliente auxCliente = existeCliente(dni); // BUSCO EL CLIENTE SI EXISTE

        if (auxCliente != null) {
            MedioDePago auxMedioPago = auxCliente.tengoMedioDePago(medioPagoId); // REVISO SI EL CLIENTE TIENE EL ID DEL MEDIO DE PAGO
            if (auxMedioPago != null) {
                Cochera auxCochera = esDisponibleCochera(tamanno); // COMPRUEBO SI TENGO UNA COCHERA DISPONIBLE CON EL TAMA�O A USAR
                if (auxCochera != null) {
                    Contrato contratoExistente = exiteContrato(auxCliente, auxMedioPago, auxCochera, periodoInicio, periodoFin);
                    if (contratoExistente == null) {
                        contratoExistente = new Contrato(periodoInicio, periodoFin, auxCliente, auxCochera, auxMedioPago);
                        contratos.add(contratoExistente);
                        auxCochera.ocuparCochera(patente, marca, modelo, tamanno); // OCUPO LA COCHERA QUE ANTES ESTABA VACIA
                    }

                }
            }
        }
    }

    /**
     * DOY DE BAJA LOGICA AL CONTRATO DE UN CLIENTE
     *
     * @param dni
     * @param idContrato
     */
    public void darBajaContrato(String dni, long idContrato) {
        Cliente aux = existeCliente(dni); // BUSCO EL CLIENTE SI EXISTE

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
    private Cochera esDisponibleCochera(long tamanno) {
        for (Cochera cochera : cocheras) {
            if (cochera.esDisponible(tamanno))
                return cochera;
        }
        return null;
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
        Cliente aux = existeCliente(dni); // BUSCO EL CLIENTE SI EXISTE

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
        Cliente aux = existeCliente(dni); // BUSCO EL CLIENTE SI EXISTE

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
    public void altaMedioDePagoEfectivo(String dni) {
        Cliente auxCliente = existeCliente(dni);
        if (auxCliente != null)
            auxCliente.AgregarMedioDePagoEfectivo();
    }

    public void altaMedioDePagoDebitoCBU(String dni, String cbu, String entidadbancaria) {
        Cliente auxCliente = existeCliente(dni);
        if (auxCliente != null)
            auxCliente.AgregarMedioDePagoDebitoCBU(cbu, entidadbancaria);
    }

    public void altaMediopagoDebitoTarjetaCredito(String dni, String entidad_emisora, long numero_tarjeta, Date fecha_vencimiento) {
        Cliente auxCliente = existeCliente(dni);
        if (auxCliente != null)
            auxCliente.AgregarMedioDePagoDebitoCredito(entidad_emisora, numero_tarjeta, fecha_vencimiento);
    }

    /**
     * @param int
     * @param int
     * @param int
     */
    public void modificarMedioDePagoTarjetaCredito(String dni, int id_medio_de_pago, String entidad_emisora, long numero_tarjeta,
                                                   Date fecha_vencimiento) {
        Cliente auxCliente = existeCliente(dni);
        if (auxCliente != null) {
            MedioDePago auxMedioPago = auxCliente.tengoMedioDePago(id_medio_de_pago); // BUSCO SI EXISTE EL MEDIO DE PAGO
            if (auxMedioPago != null && auxMedioPago instanceof DebitoTarjetaCredito) {
                ((DebitoTarjetaCredito) auxMedioPago).setEntidad_emisora(entidad_emisora);
                ((DebitoTarjetaCredito) auxMedioPago).setNumero_tarjeta(numero_tarjeta);
                ((DebitoTarjetaCredito) auxMedioPago).setFecha_vencimiento(fecha_vencimiento);
            }
        }
    }


    /**
     * @param int
     * @param int
     */
    public void modificarMedioDePagoDebitoCBU(String dni, int id_medio_de_pago, long numero_facturacion,
                                              String entidad_bancaria, String cbu) {
        Cliente auxCliente = existeCliente(dni); // BUSCO SI EXISTE EL CLIENTE
        if (auxCliente != null) {
            MedioDePago auxMedioPago = auxCliente.tengoMedioDePago(id_medio_de_pago); // BUSCO SI EXISTE EL MEDIO DE PAGO
            if (auxMedioPago != null && auxMedioPago instanceof DebitoCBU) {
                ((DebitoCBU) auxMedioPago).setEntidad_bancaria(entidad_bancaria);
                ((DebitoCBU) auxMedioPago).setCbu(cbu);
            }
        }
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
        if (existeCliente(dni) == null) {
            Cliente nuevoCliente = new Cliente(dni, nombre, domicilio, telefono, mail);
            clientes.add(nuevoCliente);
        }
    }

    /**
     * @param DNI
     */
    public void eliminarCliente(String DNI) {
        Cliente aux = existeCliente(DNI);
        if (aux != null) {
            clientes.remove(aux);
        }
    }

    /**
     * @param Domicilio
     * @param Telefono
     * @param Mail
     * @param Estado
     */
    public void modificarCliente(String dni, String nombre, String domicilio, String telefono, String mail) {
        Cliente aux = existeCliente(dni);
        System.out.println(aux);
        if (aux != null) {
            aux.setNombre(nombre);
            aux.setDomicilio(domicilio);
            aux.setTelefono(telefono);
            aux.setMail(mail);
        }
    }

    public Cliente existeCliente(String dni) {

        for (int i = 0; i < clientes.size(); i++) {
            Cliente aux = (Cliente) clientes.get(i);
            if (aux.getDni().equalsIgnoreCase(dni))
                return aux;
        }
        return null;
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

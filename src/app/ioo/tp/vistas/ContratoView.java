package app.ioo.tp.vistas;

import java.util.Date;

/**
 * Created by josur on 29/11/2015.
 */
public class ContratoView {

    private long idContrato;

    private ClienteView clienteView;

    private CocheraView cocheraView;
    private AutoView autoView;

    private MedioDePagoView medioDePagoView;

    private Date fechaInicio;

    private Date fechaFin;

    public ContratoView() {
    }

    public ContratoView(long idContrato, ClienteView clienteView, CocheraView cocheraView, AutoView autoView, MedioDePagoView medioDePagoView, Date fechaInicio, Date fechaFin) {
        this.idContrato = idContrato;
        this.clienteView = clienteView;
        this.cocheraView = cocheraView;
        this.autoView = autoView;
        this.medioDePagoView = medioDePagoView;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public long getIdContrato() {
        return idContrato;
    }

    public ClienteView getClienteView() {
        return clienteView;
    }

    public void setClienteView(ClienteView clienteView) {
        this.clienteView = clienteView;
    }

    public AutoView getAutoView() {
        return autoView;
    }

    public void setAutoView(AutoView autoView) {
        this.autoView = autoView;
    }

    public MedioDePagoView getMedioDePagoView() {
        return medioDePagoView;
    }

    public void setMedioDePagoView(MedioDePagoView medioDePagoView) {
        this.medioDePagoView = medioDePagoView;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}

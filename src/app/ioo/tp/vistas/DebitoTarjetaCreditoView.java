package app.ioo.tp.vistas;

import java.util.Date;

/**
 * Created by josur on 30/11/2015.
 */
public class DebitoTarjetaCreditoView extends MedioDePagoView {

    private String entidad_emisora;
    private long numero_tarjeta;
    private Date fecha_vencimiento;

    public DebitoTarjetaCreditoView(int id, long numero_tarjeta, String entidad_emisora, Date fecha_vencimiento) {
        super(id);

        this.numero_tarjeta = numero_tarjeta;
        this.entidad_emisora = entidad_emisora;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getEntidad_emisora() {
        return entidad_emisora;
    }

    public long getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }
}

package app.ioo.tp.vistas;

/**
 * Created by josur on 29/11/2015.
 */
public abstract class MedioDePagoView {

    public final static String MEDIO_PAGO_EFECTIVO = "efectivo";
    public final static String MEDIO_PAGO_CBU = "cbu";
    public final static String MEDIO_PAGO_TARJETA_CREDITO = "tarjeta_credito";

    protected int id;

    public MedioDePagoView(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

package app.ioo.tp.vistas;

/**
 * Created by josur on 30/11/2015.
 */
public class DebitoCBUView extends MedioDePagoView {
    private final String cbu;
    private final String entidad_bancaria;

    public DebitoCBUView(int id, String cbu, String entidad_bancaria) {
        super(id);

        this.cbu = cbu;
        this.entidad_bancaria = entidad_bancaria;
    }

    public String getCbu() {
        return cbu;
    }

    public String getEntidad_bancaria() {
        return entidad_bancaria;
    }
}

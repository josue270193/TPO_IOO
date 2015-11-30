package app.ioo.tp.vistas;

/**
 * Created by josur on 29/11/2015.
 */
public class AutoView {

    private String patente;

    private String marca;

    private String modelo;

    private long tamanno;

    public AutoView(String patente, String marca, String modelo, long tamanno) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.tamanno = tamanno;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public long getTamanno() {
        return tamanno;
    }
}

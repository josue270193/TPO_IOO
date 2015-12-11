package app.ioo.tp.vistas;

import app.ioo.tp.TipoCochera;

/**
 * Created by josur on 10/12/2015.
 */
public class CocheraView {

    private int numero;

    private TipoCochera tipo;

    private double costoCochera;

    private int disponible;

    private AutoView auto;


    public CocheraView(int numero, TipoCochera tipo, double costoCochera, int disponible, AutoView auto) {
        this.numero = numero;
        this.tipo = tipo;
        this.costoCochera = costoCochera;
        this.disponible = disponible;
        this.auto = auto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public AutoView getAuto() {
        return auto;
    }

    public void setAuto(AutoView auto) {
        this.auto = auto;
    }
}

package app.ioo.tp;

import app.ioo.tp.vistas.EfectivoView;
import app.ioo.tp.vistas.MedioDePagoView;

public class Efectivo extends MedioDePago {

	public Efectivo() {
		super();
	}

	@Override
	public MedioDePagoView crearMedioDePagoView() {
		return new EfectivoView(getId());
	}

}
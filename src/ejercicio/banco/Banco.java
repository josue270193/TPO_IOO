package ejercicio.banco;

import java.util.Vector;

public class Banco {
	
	private Vector <Cuenta> cuentas;
	private Vector <Cliente> clientes;
	
	public Banco()
	{
		cuentas = new Vector <Cuenta>();
		clientes = new Vector <Cliente>();
	}

	
// Metodos de busqueda 	
	
	private Cliente buscarCliente (String dni)
	{
		for (int i=0; i < clientes.size(); i++)
		{
			Cliente c = clientes.elementAt(i);
			if (c.sosElCliente(dni))
			{
				return c;
			}
		}
		return null;
	}
	
	private Cuenta buscarCuenta (int nro)
	{
		for (int i=0; i < cuentas.size(); i++)
		{
			Cuenta cuenta = cuentas.elementAt(i);
			if (cuenta.sosLaCuenta(nro))
			{
				return cuenta;
			}
		}
		return null;
		
// M�todos que resuelven el negocio
	
	}
	public void abrirCajaAhorro(String nombre, String dni)
	{
		Cliente c = buscarCliente(dni);
		if (c == null)
		{
			c = new Cliente (dni, nombre);
			clientes.add(c);
		}
			CajaAhorro ca = new CajaAhorro (c);
			cuentas.add(ca);
	}
	
	public void abrirCuentaCorriente(String nombre, String dni)
	{
		Cliente c = buscarCliente(dni);
		if (c == null)
		{
			 c = new Cliente (dni, nombre);
			clientes.add(c);
		}
			CuentaCorriente cc = new CuentaCorriente (c);
			cuentas.add(cc);
	}
	
	public void debitarComisiones (int comision)
	{
		for (int i=0; i < cuentas.size(); i++)
		{
			Cuenta cuenta = cuentas.elementAt(i);
			cuenta.extraer(comision);
		}
	}
	
	public void depositar (int nro, int monto)
	{
		Cuenta cuenta = buscarCuenta (nro);
		if (cuenta != null)
		{
			cuenta.debitar(monto);
		}
	}
	
	public void extraer (int nro, int monto)
	{
		Cuenta cuenta = buscarCuenta (nro);
		if (cuenta != null)
		{
			cuenta.extraer (monto);
		}
	}
	
	public Vector <VistaCuenta> listarCuentas()
	{
		Vector <VistaCuenta> vistasCtas = new Vector <VistaCuenta>();
		for (int i=0; i < cuentas.size(); i++)
		{
			Cuenta cta = cuentas.elementAt(i);
			VistaCuenta vc = cta.crearVista();
			vistasCtas.add(vc);
			
		}
		return vistasCtas;
	}
	
}

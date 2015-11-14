package ejercicio.banco;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
/**
  * @author: Maria Paula Sarasa
 */
public class MainBanco {
	private Banco banco;

// Constructor de la clase MainBanco	
	public MainBanco()
	{
		banco = new Banco();
	}

// Aca comienzan los m�todos de las distintas opciones que muestra el men�.	
	
	public void abrirCuenta()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("ALTA DE CUENTA");
			System.out.println("---------------");
			System.out.print("Ingrese nombre cliente:");
			String nombre = reader.readLine();
			System.out.println("");
			System.out.print("Ingrese DNI:");
			String dni = reader.readLine();
			System.out.print("Seleccione si la nueva cuenta sera Caja Ahorro o Cuenta Corriente (CA - CC):");
			String tipoCuenta = reader.readLine();
			if (tipoCuenta.equalsIgnoreCase("CA"))
				banco.abrirCajaAhorro(nombre,dni);
			else
				banco.abrirCuentaCorriente(nombre,dni);
			
			mostrarMenu();
		}
		catch(Exception e)
		{
			System.out.println("No pudo crear la cuenta");
		}

	}


	public void debitarComisiones() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("DEBITAR COMISIONES");
			System.out.println("-------------------");
			System.out.print("Ingrese comision a debitar:");
			String com = reader.readLine();
			int comision = Integer.parseInt(com);	
			banco.debitarComisiones(comision);
			
			mostrarMenu();
		}
		catch(Exception e)
		{
			System.out.println("No se pudieron debitar las comisiones");
			
		}
	}

	
	public void depositar() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("DEPOSITAR");
			System.out.println("-------------------");
			System.out.print("Ingrese numero de cuenta:");
			String nroCuenta = reader.readLine();
			System.out.print("Ingrese monto a depositar:");
			String mon = reader.readLine();
			int nro = Integer.parseInt(nroCuenta);
			int monto = Integer.parseInt(mon);	
			banco.depositar(nro, monto);
			
			mostrarMenu();	
		}
		catch(Exception e)
		{
			System.out.println("ERROR!!!!!! No se pudo depositar");
			
		}
	}


	public void extraer() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("EXTRAER");
			System.out.println("-------------------");
			System.out.print("Ingrese numero de cuenta:");
			String nroCuenta = reader.readLine();
			System.out.print("Ingrese monto a extraer:");
			String mon = reader.readLine();
			int nro = Integer.parseInt(nroCuenta);
			int monto = Integer.parseInt(mon);	
			banco.extraer(nro, monto);
			
			mostrarMenu();	
		}
		catch(Exception e)
		{
			System.out.println("ERROR!!!!!! No se pudo realizar la extracci�n");
			
		}
	}



	public void listarCuentas()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("LISTAR CUENTAS");
			System.out.println("---------------");
		
			Vector <VistaCuenta> cuentas = banco.listarCuentas();
			for (int i=0;i<cuentas.size();i++)
			{
				VistaCuenta c = cuentas.elementAt(i);
				System.out.println("NRO CUENTA: "+ c.getNumero());
				System.out.println("TITULAR: "+ c.getNombre());
				System.out.println("SALDO: "+ c.getSaldo());
				System.out.println("----------------------------------------------------");			
			}

			mostrarMenu();
		}
		catch(Exception e)
		{
		}
	}

//M�todo que permite levantar una aplicaci�n

	public static void main(String[] args)
	{
		// Inserte aqu� c�digo para iniciar la aplicaci�n.
		MainBanco main = new MainBanco();
		main.mostrarMenu();
	
	}

	
	
	public void mostrarMenu() 
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 	
		//Imprimo menu de opciones
		System.out.println("MENU DE OPCIONES");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Abrir Cuenta");
		System.out.println("2.- Depositar");
		System.out.println("3.- Extraer");
		System.out.println("4.- Debitar comisiones");
		System.out.println("5.- Listar cuentas");
		System.out.println("6.- Salir");
		System.out.println("-------------------------------------------------------");
		System.out.print("Opcion:");
		try
		{
			char s = (char)reader.read();
		
			switch (s)
			{
				case '1' : this.abrirCuenta();
				case '2' : this.depositar();
				case '3' : this.extraer();
				case '4' : this.debitarComisiones();
				case '5' : this.listarCuentas();
				case '6' : this.salir();
			}
		}
		catch (Exception e)
		{
		}

	}

	
	public void salir() 
	{
		System.exit(0);
	}


}

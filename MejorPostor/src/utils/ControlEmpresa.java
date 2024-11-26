package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import logica.ComparadorMonto;
import logica.Empresa;
import logica.Oferta;
import logica.Solucion;
import logica.SolverGoloso;

public class ControlEmpresa {
	
	private static Empresa empresa = new Empresa();
	private static Solucion solucion = new Solucion();
	
	public static void guardar(Oferta oferta) {
		empresa.agregar(oferta);
	}

	public static boolean verificarOfertaRepetida(Oferta oferta) {
		
		return empresa.verificarOfertaRepetida(oferta);
	}
	
	public static void obtenerSolucion () {
		
		ComparadorMonto comparador = new ComparadorMonto();
		SolverGoloso solver = new SolverGoloso(empresa, comparador);
		solucion = solver.resolver();
		
	}
	
	public static boolean verificarDiaTermino() {
		LocalDate ret = LocalDate.now();
		ret = ret.plusDays(1);
		String fechaVerificar = ret.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		for(Oferta of : InfoOfertas.getOfertasSeleccionadas()) {
			if(of.getFechaManiana().equals(fechaVerificar)) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Oferta> getOfertaSolucion() {
		return solucion.getOfertas();
	}

}

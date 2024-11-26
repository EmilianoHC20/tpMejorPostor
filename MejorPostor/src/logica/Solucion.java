package logica;

import java.util.ArrayList;

public class Solucion {
	
	private ArrayList<Oferta> _ofertas;
	
	public Solucion()
	{
		_ofertas = new ArrayList<Oferta>();
	}
	
	public void agregar(Oferta objeto)
	{
		_ofertas.add(objeto);
	}

	public int tamanio()
	{
		return _ofertas.size();
	}
	
	public double montoTotal() {
		double montoTotal = 0;
		for(Oferta oferta : _ofertas)
			montoTotal += oferta.getMonto();
		return montoTotal;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Oferta> getOfertas(){
		return (ArrayList<Oferta>) _ofertas.clone();
	}
	
	public boolean validarSuperposicion(Oferta oferta) {
		
		if(_ofertas.isEmpty()) {
			return true;	
		}
		
		for(Oferta ofertaSeleccionada : _ofertas) {
			
			if (!oferta.seSuperpone(ofertaSeleccionada)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() 
	{
		String ret = ""; 
		for (Oferta oferta: _ofertas)
			ret = ret + " " + oferta.getOferente() + " " + oferta.getHoraDesde()
			 + " " + oferta.getHoraHasta() + " " + oferta.getMonto() + "\n";
			
		return " Solucion [ofertas=" + ret + " ]";
	}

}
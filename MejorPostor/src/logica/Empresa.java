package logica;

import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<Oferta> _ofertas;
	
	public Empresa () {
		_ofertas = new ArrayList<Oferta>();
	}

	
	public void agregar(Oferta oferta)
	{
		_ofertas.add(oferta);
	}
	
	public boolean verificarOfertaRepetida(Oferta oferta) {	
		for (Oferta of : _ofertas) {
			if (oferta.equals(of))
					return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Oferta> getOfertas()
	{
		return (ArrayList<Oferta>) _ofertas.clone();
	}

	public Oferta getOferta(int i) {
		
		return _ofertas.get(i);
	}
}
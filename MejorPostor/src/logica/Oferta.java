package logica;

import java.util.Objects;

public class Oferta {
	
	private String _oferente;
	private int _horaDesde;
	private int _horaHasta;
	private int cantidadDeHoras;
	private double _monto;
	private String _tipoShow;
	private String _fechaManiana;
	
	public Oferta(String oferente, int horaDesde, int horaHasta, double monto, String tipoShow, String fechaManiana) {
		this._oferente = oferente;
		this._horaDesde = horaDesde;
		this._horaHasta = horaHasta;
		this.cantidadDeHoras=horaHasta-horaDesde;
		this._monto = monto;
		this._tipoShow = tipoShow;
		this._fechaManiana = fechaManiana;
	}
		
	
	public boolean equals(Oferta otro) {
		if(this == otro) return true;  //Si son el mismo objeto.
		
		return _oferente.equals(otro.getOferente()) &&
				_tipoShow.equals(otro.getTipoShow()) &&
				_fechaManiana.equals(otro.getFechaManiana()) &&
				Integer.compare(_horaHasta, otro.getHoraHasta()) == 0 &&
				Integer.compare(_horaDesde, otro.getHoraDesde()) == 0 &&
				Double.compare(_monto, otro.getMonto()) == 0;
	}
	
	
	public boolean seSuperpone(Oferta ofertaSeleccionada) {
		 
		int horaDesdeSeleccionada = ofertaSeleccionada.getHoraDesde();
		int horaHastaSeleccionada = ofertaSeleccionada.getHoraHasta();
			
		if(this._horaDesde > horaDesdeSeleccionada && this._horaDesde < horaHastaSeleccionada ||
		   this._horaHasta > horaDesdeSeleccionada && this._horaHasta < horaHastaSeleccionada ||
		   this._horaDesde < horaDesdeSeleccionada && this._horaHasta > horaHastaSeleccionada || 
		   this._horaDesde > horaDesdeSeleccionada && this._horaHasta < horaDesdeSeleccionada ||
		   this._horaDesde == horaDesdeSeleccionada || this._horaHasta == horaHastaSeleccionada)
			return false;
				
				
		return true;
	}
	
	public int hashCode() {
		return Objects.hash(_oferente, _tipoShow, _fechaManiana, _horaDesde, _horaHasta, _monto);
	}
	
	public String getOferente() {
		return _oferente;
	}
	
	public int getHoraDesde() {
		return _horaDesde;
	}

	public int getHoraHasta() {
		return _horaHasta;
	}

	public double getMonto() {
		return _monto;
	}

	public String getFechaManiana() {
		return _fechaManiana;
	}
	
	public String getTipoShow() {
		return _tipoShow;
	}
	
	public int getCantidadDeHoras() {
		return cantidadDeHoras;
	}
}

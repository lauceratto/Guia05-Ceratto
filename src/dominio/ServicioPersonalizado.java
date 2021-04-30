package dominio;

public class ServicioPersonalizado extends Servicio{
	private Boolean urgente = false;
	private Double costoTotal;
	private Double presupuesto;
	private Double costoMateriales;
	private Double costoTransporte;
	private Oficio oficio;
	
	//CONSTRUCTOR
	public ServicioPersonalizado(Boolean urgente, Double presupuesto, Double costoMateriales,Double costoTransporte) {
		this.urgente = urgente;
		this.presupuesto = presupuesto;
		this.costoMateriales = costoMateriales;
		this.costoTransporte = costoTransporte;
	//	this.oficio = oficio;
	}
	//GETTERS Y SETTERS
	public Boolean getUrgente() {
		return urgente;
	}
	public void setUrgente(Boolean urgente) {
		this.urgente = urgente;
	}
	public Double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Double getCostoMateriales() {
		return costoMateriales;
	}
	public void setCostoMateriales(Double costoMateriales) {
		this.costoMateriales = costoMateriales;
	}
	public Double getCostoTransporte() {
		return costoTransporte;
	}
	public void setCostoTransporte(Double costoTransporte) {
		this.costoTransporte = costoTransporte;
	}


	//FUNCIONES
	public Double costo(Boolean urgente, Double presupuesto, Double costoMateriales,
			Double costoTransporte) {
		
		costoTotal = this.presupuesto + this.costoMateriales + this.costoTransporte;
		
		if(this.urgente == true) {
			costoTotal = costoTotal*0.5+ costoTotal;
		}
	return costoTotal;	
	}
}

package dominio;

public class ServicioEstandar extends Servicio {
	private Double montoFijo;
	private Boolean urgente = false;
	private Double plus;
//	private Oficio oficio;
	
	public ServicioEstandar(Boolean urgente, Double montoFijo, Double plus) {
		this.urgente = urgente;
		this.montoFijo = montoFijo;
		this.plus = plus;
	}
	
	public Double getMontoFijo() {
		return montoFijo;
	}
	public void setMontoFijo(Double montoFijo) {
		this.montoFijo = montoFijo;
	}
	public Boolean getUrgente() {
		return urgente;
	}
	public void setUrgente(Boolean urgente) {
		this.urgente = urgente;
	}
	
	//VER BIEN QUE SE DEBE CALCULAR
	public Double costo(Boolean urgente, Double montoFijo) {
		
		if(urgente == true) {
			this.montoFijo = this.montoFijo*0.5+ this.montoFijo + this.plus;
		}
		return this.montoFijo;
	}
	

}

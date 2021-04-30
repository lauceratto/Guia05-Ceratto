package dominio;

import java.time.LocalDate;

public class Trabajo implements Contratable{

	private Servicio tipo;
	private Oficio oficio;
	private Boolean urgente;
	private String nombre;
	private Trabajador trabajador;
	private ServicioPersonalizado personalizado;
	private ServicioEstandar estandar;
	private LocalDate fecha;
	
	public Trabajo(Servicio tipo, Oficio oficio,Boolean urgente, Trabajador trabajador, LocalDate fecha) {
		super();
		this.tipo = tipo;
		this.oficio = oficio;
		this.urgente = urgente;
		this.trabajador = trabajador;
		this.fecha = fecha;
	}


	public Servicio getTipo() {
		return tipo;
	}

	public void setTipo(Servicio tipo) {
		this.tipo = tipo;
	}

	public Oficio getOficio() {
		return oficio;
	}


	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}


	public Boolean getUrgente() {
		return urgente;
	}


	public void setUrgente(Boolean urgente) {
		this.urgente = urgente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Trabajador getTrabajador() {
		return trabajador;
	}


	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	@Override
	public Boolean finalizado() {
		if(this.fecha!=null) {
			return true;
		}else {
			return false;
		}
	}

	public Double precio() {
		Double precio1=0.0;
		if(this.tipo instanceof ServicioEstandar) {
			precio1=(((ServicioEstandar)this.tipo)).costo(((ServicioEstandar) this.tipo).getUrgente(),((ServicioEstandar) this.tipo).getMontoFijo()); 
		}else if(this.tipo instanceof ServicioPersonalizado) {
			
			precio1=((ServicioPersonalizado) this.tipo).costo(((ServicioPersonalizado) this.tipo).getUrgente(), ((ServicioPersonalizado) this.tipo).getPresupuesto(), ((ServicioPersonalizado) this.tipo).getCostoMateriales(), ((ServicioPersonalizado) this.tipo).getCostoTransporte());
					
		}
		return precio1;
	}

	
	
	

}

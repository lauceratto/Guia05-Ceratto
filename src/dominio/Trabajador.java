package dominio;

import java.util.ArrayList;
import java.util.List;

import exception.AgendaOcupadaException;
import exception.OficioNoCoincideException;

public class Trabajador {
	
	private String nombre;
	private String oficio;
	private String correo;
	private Double costoPorHora;
	private Double porcentajePorComision;
	private List<Trabajo> trabajosAsignados = new ArrayList<>();

	//CONSTRUCTOR	
	
	public Trabajador() {
		
		
	}
	public Trabajador(String nombre, String oficio, String correo, Double costoPorHora, Double porcentajePorComision) {
		this.nombre = nombre;
		this.oficio = oficio;
		this.correo = correo;
		this.costoPorHora = costoPorHora;
		this.porcentajePorComision = porcentajePorComision;

	}


	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Double getCostoPorHora() {
		return costoPorHora;
	}
	public void setCostoPorHora(Double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}
	public Double getPorcentajePorComision() {
		return porcentajePorComision;
	}
	public void setPorcentajePorComision(Double porcentajePorComision) {
		this.porcentajePorComision = porcentajePorComision;
	}
	public List<Trabajo> getTrabajosAsignados() {
		return trabajosAsignados;
	}
	public void setTrabajosAsignados(List<Trabajo> trabajosAsignados) {
		this.trabajosAsignados = trabajosAsignados;
	}
	
	//METODOS
	public void addTrabajos(Trabajo t) throws OficioNoCoincideException, AgendaOcupadaException {
		if(t.getTrabajador().oficio == t.getOficio().getNombre()) {
	//		for(Trabajo trabajo: this.trabajosAsignados) {
			//	if(trabajo.getFecha().equals(t.getFecha())) {
				
				//	throw new AgendaOcupadaException("Es imposible contratar un trabajo en esta fecha ya que el trabajador tiene otro trabajo agendado");
			//	}else {
					this.trabajosAsignados.add(t);
			//	}
			//}
		}else {
			throw new OficioNoCoincideException("El oficio "+t.getOficio().getNombre()+" no coincide con el oficio del trabajador ("+t.getTrabajador().oficio+")");
		}
			
	}
	public void mostrarTrabajos() {
		for (Trabajo trabajo : trabajosAsignados) {
			  System.out.println(trabajo.getTipo().getClass().getSimpleName());
			  System.out.println("¿Era urgente? "+trabajo.getUrgente());
			  System.out.println(trabajo.getFecha());
			}
	}
	
	public void obtenerTrabajoPorFecha() {
		
	}

}

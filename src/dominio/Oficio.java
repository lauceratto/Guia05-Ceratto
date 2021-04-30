package dominio;

import java.util.ArrayList;
import java.util.List;


public class Oficio {
	private List<String> oficios = new ArrayList<>();
	private String nombre;
	
	public Oficio() {

	}


	public Oficio(String nombre) {
		this.nombre = nombre;
	}

	
	public void addOficios(String o) {
		this.oficios.add(o);
		
	}


	public List<String> getOficios() {
		return oficios;
	}


	public void setOficios(List<String> oficios) {
		this.oficios = oficios;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	
}

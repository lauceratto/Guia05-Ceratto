package dominio;

public class Herramienta {
	
	private String nombre;
	private Double costoPorDia;
		
	public Herramienta(String nombre, Double costoPorDia) {
		super();
		this.nombre = nombre;
		this.costoPorDia = costoPorDia;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCostoPorDia() {
		return costoPorDia;
	}
	public void setCostoPorDia(Double costoPorDia) {
		this.costoPorDia = costoPorDia;
	}

	

}

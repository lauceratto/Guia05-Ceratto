package dominio;

import java.time.LocalDate;
import java.util.List;

import exception.AlquilerNoEntregadoException;

import static java.time.temporal.ChronoUnit.DAYS;

public class Alquiler implements Contratable{
	
	private Herramienta herramienta;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private LocalDate fechaRealDevolucion;
	private Integer contador = 0;
	private	Usuario usuario;
	
	public Alquiler(Herramienta herramienta, LocalDate fechaAlquiler, LocalDate fechaRealDevolucion) {
		this.herramienta = herramienta;
		this.fechaAlquiler = fechaAlquiler;
		this.fechaRealDevolucion = fechaRealDevolucion;
		
	}
	
	public Alquiler(Herramienta herramienta, LocalDate fechaAlquiler, LocalDate fechaDevolucion, LocalDate fechaRealDevolucion) {
		this.herramienta = herramienta;
		this.fechaAlquiler = fechaAlquiler;
		this.fechaDevolucion = fechaDevolucion;
		this.fechaRealDevolucion = fechaRealDevolucion;
		
	}

//	public Alquiler(Usuario u1) {
//		// TODO Auto-generated constructor stub
//		this.usuario = u1;
//	}
	//GETTERS Y SETTERS
	public Herramienta getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public LocalDate getFechaRealDevolucion() {
		return fechaRealDevolucion;
	}

	public void setFechaRealDevolucion(LocalDate fechaRealDevolucion) {
		this.fechaRealDevolucion = fechaRealDevolucion;
	}
	//METODOS
	public Double precio() {
		// TODO Auto-generated method stub
		if(this.fechaDevolucion == null) {
			LocalDate diaHoy = LocalDate.now();
			Integer diasAlquilados = (int) DAYS.between(this.fechaAlquiler,diaHoy);
			if(diasAlquilados == 0) {
				return herramienta.getCostoPorDia();
			}else {
				return diasAlquilados*herramienta.getCostoPorDia();
			}
		}else{
			Integer diasAlquilados = (int) DAYS.between(this.fechaAlquiler,this.fechaDevolucion);
			if(diasAlquilados == 0) {
				return herramienta.getCostoPorDia();
			}else {
				return diasAlquilados*herramienta.getCostoPorDia();
			}
		}
		
	}
//	public void mostrar() {
//		System.out.println("El precio del usuario " +this.usuario +" es: "+this.precio());
//	}
//	

	public Boolean enMora() {
		if(this.fechaDevolucion!=null && this.fechaRealDevolucion!=null) {
			if(this.fechaDevolucion.compareTo(this.fechaRealDevolucion)<0) {
				return true;
			}
		}else if (this.fechaDevolucion.compareTo(LocalDate.now())<0) {
			return true;			
		}
		return false;
	}

	@Override
	public Boolean finalizado() {
		if(this.fechaRealDevolucion!=null && this.fechaRealDevolucion.isBefore(LocalDate.now())) {
			return true;
		}else {
			return false;

		}
	}
	
	public void alquileres(List<Contratable> lista) throws AlquilerNoEntregadoException {
		for(Contratable alquiler: lista) {
			if(alquiler.finalizado() == false) {
				this.contador++;
				if(this.contador > 2) {
					throw new AlquilerNoEntregadoException("No puede alquilar ya que tiene 2 alquileres sin devolver");
				}
			}
		}	
	}


	
}

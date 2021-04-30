package dominio;

import java.util.ArrayList;
import java.util.List;

import exception.AgendaOcupadaException;
import exception.AlquilerNoEntregadoException;
import exception.OficioNoCoincideException;

public class Usuario {
	private String usuario;
	private List<Contratable> lista = new ArrayList<>();
	private Integer contador = 0;
	
	public Usuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void contratar(Contratable h) throws OficioNoCoincideException, AgendaOcupadaException, AlquilerNoEntregadoException {
		try {
			if(h instanceof Trabajo) {
				((Trabajo) h).getTrabajador().addTrabajos((Trabajo) h);		
				this.lista.add(h);
			}else if(h instanceof Alquiler){
				((Alquiler) h).alquileres(this.lista);
				this.lista.add(h);
			}
		} catch (OficioNoCoincideException e) {
			e.printStackTrace();
//			System.out.println(e.getMessage());
		} catch (AgendaOcupadaException e1) {
			e1.printStackTrace();
		//	System.out.println(e1.getMessage());
		} catch (AlquilerNoEntregadoException e2) {
			e2.printStackTrace();
//			System.out.println(e2.getMessage());
		}
	}
	public Double obtenerMonto(String mes) {
		Double precioTotal = 0.0;
		for(int i=0;i<lista.size();i++) {
			precioTotal = precioTotal + lista.get(i).precio();
		}
		return precioTotal;
	}
	
	public void mostrarContratables() {
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i));
		}
	}
	
}

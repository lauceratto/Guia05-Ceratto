package AppReparaFix;

import java.time.LocalDate;
import java.time.Month;

import exception.AgendaOcupadaException;
import exception.AlquilerNoEntregadoException;
import exception.OficioNoCoincideException;
import dominio.Alquiler;
import dominio.Contratable;
import dominio.Herramienta;
import dominio.Oficio;
import dominio.ServicioEstandar;
import dominio.ServicioPersonalizado;
import dominio.Trabajador;
import dominio.Trabajo;
import dominio.Usuario;

public class AppReparaFix {
	public static void main(String[] args) throws OficioNoCoincideException, AgendaOcupadaException, AlquilerNoEntregadoException {
		// TODO Auto-generated method stub
		Double plusReparaFix = 200.0;
		Usuario u1 = new Usuario("lauceratto");
		Usuario u2 = new Usuario("Juanfer");
		Herramienta h1= new Herramienta("Escalera",300.0);
		Herramienta h2= new Herramienta("Sierra",150.0);
		Herramienta h3= new Herramienta("Compresor",450.0);
		Herramienta h4= new Herramienta("Filtro",80.0);
		Trabajador t1= new Trabajador("Rogelio","Plomero","roger33@hotmail.com",130.0,15.0);
		Trabajador t2= new Trabajador("Juan","Electricista","JuanPerez@gmail.com",130.0,15.0);
		Oficio of1= new Oficio("Electricista");
		Oficio of2= new Oficio("Plomero");
		Trabajo trabajo = new Trabajo(new ServicioEstandar(true,10.2,plusReparaFix),of2, true, t1,LocalDate.of(2021, Month.APRIL, 28));
		Trabajo trabajo1 = new Trabajo(new ServicioPersonalizado(true,2000.0,3200.0, 800.0),of1, true, t1,LocalDate.of(2021, Month.APRIL, 20));
		Trabajo trabajo3 = new Trabajo(new ServicioPersonalizado(false,700.0,1000.0,140.5),of2, false, t1,LocalDate.of(2021, Month.APRIL, 28));
		Alquiler alquiler1 = new Alquiler(h1, LocalDate.of(2021, Month.APRIL, 26), LocalDate.of(2021, Month.APRIL, 28), LocalDate.of(2021, Month.MAY, 04));
		Alquiler alquiler2 = new Alquiler(h3, LocalDate.of(2021, Month.APRIL, 27), null);
		Alquiler alquiler3 = new Alquiler(h3, LocalDate.of(2021, Month.APRIL, 25), null);
		Alquiler alquiler4 = new Alquiler(h1, LocalDate.of(2021, Month.APRIL, 23), LocalDate.of(2021, Month.APRIL, 24));
		
		
		u1.contratar(alquiler1);
		u1.contratar(alquiler2);
		u1.contratar(alquiler3);
		u1.contratar(trabajo);
		u1.contratar(trabajo1);
		u1.contratar(trabajo3);
		u1.contratar(alquiler4);
	
//		System.out.println(alquiler1.enMora());
//		System.out.println(alquiler1.finalizado());
//
//		System.out.println(trabajo.precio());
//		System.out.println(trabajo1.precio());
//		System.out.println(alquiler1.precio());
//		System.out.println(alquiler2.precio());
//
	//	u1.mostrarContratables();
		System.out.println("El monto total del usuario "+u1.getUsuario()+" en el mes es: $"+u1.obtenerMonto("Abril"));
		t1.mostrarTrabajos();
		
	}
}
